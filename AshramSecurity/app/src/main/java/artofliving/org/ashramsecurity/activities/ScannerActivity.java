package artofliving.org.ashramsecurity.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.zxing.Result;

import artofliving.org.ashramsecurity.R;
import artofliving.org.ashramsecurity.utils.AlertDialogUtil;
import artofliving.org.ashramsecurity.utils.NavigationUtil;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.content.ContentValues.TAG;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private static final int PERMISSION_REQUEST_CAMERA = 0;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_scanner);
        mScannerView = findViewById(R.id.scanner_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission();
        }

    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(ScannerActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mScannerView.setResultHandler(this);
                mScannerView.startCamera();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_select_checkpoint) {
            NavigationUtil.gotoSelectCheckpointActivity(ScannerActivity.this);
        }

        if (id == R.id.action_logout) {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void handleResult(Result rawResult) {
        String text = rawResult.getText();
        String format = rawResult.getBarcodeFormat().toString();
        Log.v(TAG, text);
        Log.v(TAG, format);

        final AlertDialog dialog = AlertDialogUtil.showSimpleDialog(ScannerActivity.this, format, text, "OK");

        /*
        ScanService.checkSecurity(ScannerActivity.this, rawResult.getText(), new ServiceCallback<GenericResponse>() {

            @Override
            public void run(GenericResponse response) {
                dialog.dismiss();
                AlertDialogUtil.showDialogWithAction(ScannerActivity.this, response.isSuccessful() ? "VALID" : "ALERT!", response.message, "OK", null, new ServiceCallback<String>() {
                    @Override
                    public void run(String data) {
                        if (data.equalsIgnoreCase("OK")) {
                            mScannerView.resumeCameraPreview(ScannerActivity.this);
                        }
                    }
                });

            }
        });
*/
//        mScannerView.resumeCameraPreview(this);
    }
}