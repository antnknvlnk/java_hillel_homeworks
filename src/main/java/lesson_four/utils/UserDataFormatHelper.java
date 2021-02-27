package lesson_four.utils;

import lesson_four.exceptions.StringFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataFormatHelper {

    public static boolean phoneNumberChecker(String phoneNumber) throws StringFormatException {
        boolean found;
        Pattern pattern = Pattern.compile("^(?:\\+38)?" +
                "(?:\\(?(044|067|068|096|097|098|050|066|095|099|063|073|093|089|094)\\)?" +
                "([.-]|\\s)?[0-9]{3}" +
                "([.-]|\\s)?[0-9]{2}" +
                "([.-]|\\s)?[0-9]{2})$");
        Matcher matcher = pattern.matcher(phoneNumber);
        found = matcher.matches();
        System.out.println("matches: " + found);
        if (found) {
            return true;
        } else {
            throw new StringFormatException();
        }
    }

    public static boolean emailChecker(String email) throws StringFormatException {
        boolean found;
        Pattern pattern = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        found = matcher.matches();
        System.out.println("matches: " + found);
        if (found) {
            return true;
        } else {
            throw new StringFormatException();
        }
    }

    public static boolean birthDateChecker(String birthDate) throws StringFormatException {
        boolean found;
        Pattern pattern = Pattern.compile("^(3[01]|[12][0-9]|0[1-9])[/.-](1[0-2]|0[1-9])[/.-][0-9]{4}$");
        Matcher matcher = pattern.matcher(birthDate);
        found = matcher.matches();
        System.out.println("matches: " + found);
        if (found) {
            return true;
        } else {
            throw new StringFormatException();
        }
    }
}
