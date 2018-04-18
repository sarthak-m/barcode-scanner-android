package artofliving.org.ashramsecurity.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.text.InputType;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import artofliving.org.ashramsecurity.R;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class AlertDialogUtil {

    public static AlertDialog showSimpleLoadingDialog(Activity activity, boolean cancellable) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View alert_view = inflater.inflate(R.layout.simple_loading_alert, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(alert_view);
        AlertDialog dialog = builder.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(cancellable);

        int size = (int) (80 * UIConstants.getScreenDensity(activity));
        dialog.getWindow().setLayout(size, size);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;
    }

    public static AlertDialog showSimpleDialog(Activity activity, String title, String message, String button) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View alert_view = inflater.inflate(R.layout.simple_message_alert, null);

        TextView tvTitle = (TextView) alert_view.findViewById(R.id.title);
        TextView tvMessage = (TextView) alert_view.findViewById(R.id.message);
        Button ok = (Button) alert_view.findViewById(R.id.ok_button);
        ok.setText(button);

        tvTitle.setText(title);
        tvMessage.setText(message);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(alert_view);
        final AlertDialog dialog = builder.show();
        dialog.setCanceledOnTouchOutside(true);

        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;
    }

    public static AlertDialog showDialogWithAction(Activity activity, String title, String message, final String positiveButtonText, final String negativeButtonText, final ServiceCallback<String> serviceCallback) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View alert_view = inflater.inflate(R.layout.simple_message_alert, null);

        TextView tvTitle = alert_view.findViewById(R.id.title);
        TextView tvMessage = alert_view.findViewById(R.id.message);

        final Button okButton = alert_view.findViewById(R.id.ok_button);
        final Button cancelButton = alert_view.findViewById(R.id.cancel_button);

        if (negativeButtonText != null) {
            cancelButton.setVisibility(View.VISIBLE);
            cancelButton.setText(negativeButtonText);
        } else {
            cancelButton.setVisibility(View.GONE);
        }
        okButton.setText(positiveButtonText);

        if (title != null && title.length() > 0) {
            tvTitle.setText(Html.fromHtml(title));
        } else {
            tvTitle.setVisibility(View.GONE);
        }

        if (message != null && message.length() > 0) {
            tvMessage.setText(Html.fromHtml(message));
        } else {
            tvMessage.setVisibility(View.GONE);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(alert_view);
        final AlertDialog dialog = builder.show();
        dialog.setCanceledOnTouchOutside(true);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceCallback.run(positiveButtonText);
                dialog.dismiss();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceCallback.run(negativeButtonText);
                dialog.dismiss();
            }
        });
        return dialog;
    }


}
