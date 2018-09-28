package dalvik.com.mx.shopcart.dalvik.com.mx.shopcart.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@_#$%^&+=])(?=\\S+$).{8,}$";

    public static boolean _validate( String str, String ptn ){
        pattern = Pattern.compile( ptn );
        matcher = pattern.matcher( str );
        return matcher.matches();
    }

    public static class Email{
        public static boolean validate( String str ){
            return  _validate( str, EMAIL_PATTERN );
        }
    }

    public static class Password{
        public static boolean validate( String str ){
            return  _validate( str, PASSWORD_PATTERN );
        }
    }
}
