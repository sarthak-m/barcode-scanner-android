package artofliving.org.ashramsecurity.models;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import artofliving.org.ashramsecurity.AshramSecurityApplication;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class TinyDB {

    private SharedPreferences preferences;

    public TinyDB() {
        preferences = PreferenceManager.getDefaultSharedPreferences(AshramSecurityApplication.getAshramSecurityApplicationContext());
    }

    /**
     * Put String value into SharedPreferences with 'key' and save
     *
     * @param key   SharedPreferences key
     * @param value String value to be added
     */
    public void putString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    /**
     * Get String value from SharedPreferences at 'key'. If key not found, return ""
     *
     * @param key SharedPreferences key
     * @return String value at 'key' or "" (empty String) if key not found
     */
    public String getString(String key) {
        return preferences.getString(key, "");
    }


}
