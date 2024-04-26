package org.utp.lobito.domain.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
//        boolean data = false ;        // esta manera es una salida rapida indicando que debe contener un @
//        if(email.contains("@")){
//           return  data = true;
//        }else {
//            return data = false;
//        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
