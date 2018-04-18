package artofliving.org.ashramsecurity.events;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import artofliving.org.ashramsecurity.AshramSecurityApplication;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class ConnectivityChangedEvent {

    private boolean isInternetConnected;

    public boolean checkNetworkConnection() {

        try {
            ConnectivityManager cm = (ConnectivityManager) AshramSecurityApplication.getAshramSecurityApplicationContext().getApplicationContext()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                Log.e("AshramSecurityApp", "Network available");
                isInternetConnected = true;
            } else {
                isInternetConnected = false;
                Log.e("AshramSecurityApp", "Network Unavailable");
            }
            return isInternetConnected;
        } catch (Exception e) {
            return false;
        }
    }
}
