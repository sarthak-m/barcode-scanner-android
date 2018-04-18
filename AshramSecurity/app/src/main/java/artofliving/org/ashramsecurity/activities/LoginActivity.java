package artofliving.org.ashramsecurity.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import artofliving.org.ashramsecurity.R;
import artofliving.org.ashramsecurity.models.GenericResponse;
import artofliving.org.ashramsecurity.services.DatabaseService;
import artofliving.org.ashramsecurity.services.UserService;
import artofliving.org.ashramsecurity.utils.AlertDialogUtil;
import artofliving.org.ashramsecurity.utils.NavigationUtil;
import artofliving.org.ashramsecurity.utils.ServiceCallback;
import artofliving.org.ashramsecurity.utils.TextUtil;

public class LoginActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (DatabaseService.isUserLoggedIn()) {
            NavigationUtil.gotoScannerActivity(LoginActivity.this);
        } else {
            mEmailView = findViewById(R.id.email);
            mPasswordView = findViewById(R.id.password);
            mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                    if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                        attemptLogin();
                        return true;
                    }
                    return false;
                }
            });

            Button mEmailSignInButton = findViewById(R.id.email_sign_in_button);
            mEmailSignInButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    attemptLogin();
                }
            });
        }
    }

    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        final String email = mEmailView.getText().toString();
        final String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!TextUtil.isEmailAddress(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            final AlertDialog dialog = AlertDialogUtil.showSimpleLoadingDialog(this, true);

            UserService.login(this, email, password, new ServiceCallback<GenericResponse>() {

                @Override
                public void run(GenericResponse response) {
                    dialog.dismiss();
                    if (response.isSuccessful()) {
                        DatabaseService.saveUser(email, password);
                        DatabaseService.saveAshram("0101");
                        NavigationUtil.gotoSelectCheckpointActivity(LoginActivity.this);
                    } else {
                        Toast.makeText(LoginActivity.this, "Some error occured", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


}

