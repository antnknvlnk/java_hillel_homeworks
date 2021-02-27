package lesson_one;

import java.io.IOException;

public interface Service {

    void checkUsers(AllUsers user) throws IOException;

    void writeUsers(AllUsers user) throws IOException;
}
