package artofliving.org.ashramsecurity.utils;

import android.app.Activity;
import android.content.Intent;

import artofliving.org.ashramsecurity.activities.HomeActivity;
import artofliving.org.ashramsecurity.activities.LoginActivity;
import artofliving.org.ashramsecurity.activities.ScannerActivity;
import artofliving.org.ashramsecurity.activities.SelectCheckpointActivity;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class NavigationUtil {

    public static void gotoHomeActivity(Activity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void gotoSelectCheckpointActivity(Activity activity) {
        Intent intent = new Intent(activity, SelectCheckpointActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void gotoScannerActivity(Activity activity) {
        Intent intent = new Intent(activity, ScannerActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void gotoLoginActivity(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
}
