package User;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checkers {
    private static final String password =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final Pattern pattern = Pattern.compile(password);
    private static String email = "^(.+)@(.+)$";
    private static final Pattern pattern2 = Pattern.compile(email);

    public static boolean passValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean emailValid(final String email) {
        Matcher matcher = pattern2.matcher(email);
        return matcher.matches();
    }



}
