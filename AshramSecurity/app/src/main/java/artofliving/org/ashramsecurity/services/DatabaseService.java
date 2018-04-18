package artofliving.org.ashramsecurity.services;

import android.util.Pair;

import artofliving.org.ashramsecurity.models.TinyDB;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class DatabaseService {

    private static final String API_KEY = "api_key";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ASHRAM = "ashram";
    private static final String CHECKPOINT_ID = "checkpoint_id";
    private static final String CHECKPOINT_NAME = "checkpoint_name";

    public static void setKey(String key) {
        TinyDB db = new TinyDB();
        db.putString(API_KEY, key);
    }

    public static String getKey() {
        TinyDB db = new TinyDB();
        return db.getString(API_KEY);
    }

    public static void saveUser(String email, String password) {
        TinyDB db = new TinyDB();
        db.putString(EMAIL, email);
        db.putString(PASSWORD, password);
    }

    static Pair<String, String> getUser() {
        TinyDB db = new TinyDB();
        return new Pair<>(db.getString(EMAIL), db.getString(PASSWORD));
    }

    public static void saveCheckPointId(String id) {
        TinyDB db = new TinyDB();
        db.putString(CHECKPOINT_ID, id);
    }

    public static void saveCheckPointName(String id) {
        TinyDB db = new TinyDB();
        db.putString(CHECKPOINT_NAME, id);
    }

    public static void saveAshram(String ashram) {
        TinyDB db = new TinyDB();
        db.putString(ASHRAM, ashram);
    }

    static String getCheckPointId() {
        TinyDB db = new TinyDB();
        return db.getString(CHECKPOINT_ID);
    }

    public static String getCheckPointName() {
        TinyDB db = new TinyDB();
        return db.getString(CHECKPOINT_NAME);
    }

    static String getAshram() {
        TinyDB db = new TinyDB();
        return db.getString(ASHRAM);
    }

    public static boolean isUserLoggedIn() {
        TinyDB db = new TinyDB();
        return !db.getString(EMAIL).equalsIgnoreCase("");
    }

    public static void logoutUser() {
        TinyDB db = new TinyDB();
        db.putString(EMAIL, "");
        db.putString(PASSWORD, "");
    }
}
