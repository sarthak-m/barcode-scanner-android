package artofliving.org.ashramsecurity.utils;

import java.util.regex.Pattern;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class TextUtil {

    // Regular Expression
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    // call this method when you need to check email validation
    public static boolean isEmailAddress(String text) {
        return Pattern.matches(EMAIL_REGEX, text);
    }


}
