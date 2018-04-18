package artofliving.org.ashramsecurity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;

import artofliving.org.ashramsecurity.events.ConnectivityChangedEvent;
import artofliving.org.ashramsecurity.services.DatabaseService;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class AshramSecurityApplication extends Application implements Application.ActivityLifecycleCallbacks {

    public static final String APPLICATION_TAG = "AshramSecurity";
    private Gson gsonObj;
    public static AshramSecurityApplication application = null;
    private static WeakReference<Activity> currentActivity;

    private static final String CONNECTIVITY_CHANGED = "CONNECTIVITY_CHANGED";
    private ConnectivityChangedEvent connectivityChanged;


    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        this.registerActivityLifecycleCallbacks(this);

    }

    public static AshramSecurityApplication getAshramSecurityApplicationContext() {
        return application;
    }

    public ConnectivityChangedEvent getInternetConnectionEvent() {
        synchronized (CONNECTIVITY_CHANGED) {
            if (connectivityChanged == null) {
                connectivityChanged = new ConnectivityChangedEvent();
            }
        }
        return connectivityChanged;
    }

    public static Activity getCurrentActivity() {
        if (currentActivity != null) {
            return currentActivity.get();
        } else {
            return null;
        }
    }

    public Gson getGsonObj() {
        if (gsonObj == null) {
            gsonObj = new Gson();
        }
        return gsonObj;
    }

    public int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public float getDensity() {
        return getResources().getDisplayMetrics().density;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        currentActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        currentActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
        currentActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        currentActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        currentActivity = null;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
        Log.i("Memory Log", "Low memory");
    }

    private void setupAPIKey(String key) {
        DatabaseService.setKey(key);
    }

    public static String getAPIKey() {
        return DatabaseService.getKey();
    }
}
