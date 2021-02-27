package lesson_one;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminService implements Service {
    boolean check = false;

    public AdminService() throws IOException {
    }

    @Override
    public void checkUsers(AllUsers user) throws IOException {
        FileReader fr = new FileReader("src/emails_read.txt");
        Scanner scan = new Scanner(fr);
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            if (user.getMail().equals(line)){
                System.out.println("User " + user.getfName() + " is in emails_read.txt file");
                check = true;
            }
        }
    }

    @Override
    public void writeUsers(AllUsers user) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/users_write.txt"));
        String[] arr =  {user.getfName(), user.getsName(), String.valueOf(user.getAge()), user.getMail(), user.getPass(), user.getRole()};
        for (String s : arr) {
            bw.append(s).append("\n");
        }
        bw.newLine();
        bw.flush();
        System.out.println("User " + user.getfName() + " has been added to file.");
    }
}
