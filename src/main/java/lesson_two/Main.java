package lesson_two;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static InitializationData initialization = new InitializationData();

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(123);
        list1.add(54);
        list1.add(7);

        initialization.fillInformation();
        initialization.print();

        System.out.println(list1);
        System.out.println(" ");
        processedInformation(list1, initialization.getInformation());
        System.out.println(" ");
        initialization.print();
    }

    private static void processedInformation (List<? extends Number> list, Information info) {
        for (Number number : list) {
            if (!info.nickname.contains("a" + number + "user")) {
                info.nickname.add("a" + number + "user");
                info.potentialUserMail.add("a" + number + "mail" + "@email.ua");
                info.nicknameMailRatio.put("a" + number + "mail" + "@email.ua", "a" + number + "mail" + "@email.ua");
            } else System.out.println("This nickname " + "a" + number + "user" + " already exits");
        }
    }
}
