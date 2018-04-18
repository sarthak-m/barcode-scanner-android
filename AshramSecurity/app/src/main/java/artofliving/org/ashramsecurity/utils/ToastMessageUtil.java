package artofliving.org.ashramsecurity.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import artofliving.org.ashramsecurity.R;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class ToastMessageUtil {

    private static View overLayView = null;
    private static Thread t = null;

    public static void showErrorToastMessage(final String text, final Activity activity, final boolean isLengthLong) {
        if (activity != null && !(UIConstants.isNullOrEmpty(text))) {
            if (t != null) {
                t.interrupt();
                t = null;
            }
            t = new Thread() {
                public void run() {
                    try {
                        overLayView = ((ViewGroup) activity.getWindow().getDecorView()).findViewWithTag("toast_overlay");
                        if (overLayView == null) {
                            LayoutInflater inflator = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            overLayView = (View) inflator.inflate(R.layout.custom_toast, null);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                            layoutParams.gravity = Gravity.START | Gravity.TOP;
                            layoutParams.setMargins(0, 50, 0, 0);
                            overLayView.setLayoutParams(layoutParams);
                            overLayView.setTag("toast_overlay");
                            TextView textView = (TextView) overLayView.findViewById(R.id.text);
                            textView.setText(text);
                            addView(activity);
                        } else {
                            if (activity != null && (!(activity.isFinishing())) && overLayView != null) {
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            TextView textView = (TextView) overLayView.findViewById(R.id.text);
                                            textView.setText(text);
                                            addView(activity);
                                        } catch (Exception e) {
                                        }
                                    }
                                });
                            }
                        }
                        if (isLengthLong) {
                            sleep(4500);
                        } else {
                            sleep(2000);
                        }
                        removeView(activity);
                    } catch (Exception e) {
                        removeView(activity);
                    }
                }
            };
            t.start();
        }
    }

    private static void addView(final Activity activity) {
        if (activity != null && (!(activity.isFinishing())) && overLayView != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ((ViewGroup) activity.getWindow().getDecorView()).addView(overLayView);
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    private static void removeView(final Activity activity) {
        if (t != null) {
            t.interrupt();
            t = null;
        }
        if (activity != null && (!(activity.isFinishing())) && overLayView != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ((ViewGroup) activity.getWindow().getDecorView()).removeView(overLayView);
                    } catch (Exception e) {
                    }
                }
            });
        }
    }
}
