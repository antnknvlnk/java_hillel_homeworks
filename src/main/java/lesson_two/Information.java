package lesson_two;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Information {
    ArrayList<String> nickname;
    TreeSet<String> potentialUserMail;
    TreeMap<String, String> nicknameMailRatio;

    public Information() {
        nickname = new ArrayList<>();
        potentialUserMail = new TreeSet<>();
        nicknameMailRatio = new TreeMap<>();
    }
}
