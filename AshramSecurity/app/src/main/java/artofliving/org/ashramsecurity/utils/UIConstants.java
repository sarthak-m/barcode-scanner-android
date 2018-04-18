package artofliving.org.ashramsecurity.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class UIConstants {

    public static final String NO_INTERNET_MSG = "Couldn\'t connect to Internet! Please try again";
    public static final String API_KEY = "";

    static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0 || str.equalsIgnoreCase("null");
    }

    private static DisplayMetrics getDisplayMetrics(Activity activity) {
        return activity.getResources().getDisplayMetrics();
    }

    static float getScreenDensity(Activity activity) {
        DisplayMetrics metrics = getDisplayMetrics(activity);
        return metrics.density;
    }
}

