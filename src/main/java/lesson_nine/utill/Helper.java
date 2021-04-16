package lesson_nine.utill;

import java.util.Optional;

public class Helper {

    public Optional<String> optionalHelper(String email) {
        if (email == null || email.isEmpty() || !email.matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            return Optional.empty();
        } else {
            return Optional.of(email);
        }
    }
}
