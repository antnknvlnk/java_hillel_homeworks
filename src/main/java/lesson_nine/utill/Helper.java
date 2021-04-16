package lesson_nine.utill;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public Optional<String> optionalHelper(String email) {
        boolean found;
        Pattern pattern = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        found = matcher.matches();

        if(email == null || email.isEmpty() || !found){
            return Optional.empty();
        } else {
            return Optional.of(email);
        }
    }
}
