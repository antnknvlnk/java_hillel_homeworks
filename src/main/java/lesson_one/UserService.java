package lesson_one;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService implements Service {
    boolean check = false;
    public UserService() throws IOException {
    }

    @Override
    public void checkUsers(AllUsers user) throws IOException {
        FileReader fr = new FileReader("src/emails_read.txt");
        Scanner scan = new Scanner(fr);
        while(scan.hasNextLine()) {
            if (user.getMail().equals(scan.nextLine())){
                System.out.println("User " + user.getfName() + " is in emails_read.txt file");
                check = true;
            }
        }
    }

    @Override
    public void writeUsers(AllUsers user) throws IOException {
        System.out.println("You have no permissions! Please, try admin service.");
    }
}
