package lesson_one;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AllUsers userUser = new User("Anton", "Kon", 26, "thad.frami@lakin.biz", "123");
        AllUsers userAdmin = new Admin("Andrew", "Nolf", 32, "francesca84@gmail.com", "345");

        Service user = new UserService();
        Service admin = new AdminService();

        user.checkUsers(userUser);
        admin.checkUsers(userAdmin);

        System.out.println();
        user.writeUsers(userUser);
        admin.writeUsers(userAdmin);
        admin.writeUsers(userUser);

        System.out.println();
        admin.checkUsers(userUser);
        user.checkUsers(userAdmin);
        user.checkUsers(userAdmin);
    }
}
