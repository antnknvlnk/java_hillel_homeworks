package lesson_four;

import lesson_four.exceptions.StringFormatException;
import lesson_four.utils.StringOperationsHelper;
import lesson_four.utils.UserDataFormatHelper;

public class Main {
    public static void main(String[] args) {

        String s = "   Anton1   ";
//        String s = "     ";
        char[] arr = {'k', 'o', 'n', 'o', 'v', 'a', 'l'};
//        char[] arr = null;
        try {
            System.out.println(StringOperationsHelper.stringOperations(s, arr));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println();

        String phoneNumber;
        phoneNumber = "+38(044)0938959"; //true
//        phoneNumber = "067)444 44-44"; //true
//        phoneNumber = "+38(000)1234567"; //true
//        phoneNumber = "044-093 89-59 00"; //false

        try {
            UserDataFormatHelper.phoneNumberChecker(phoneNumber);
        } catch (StringFormatException e) {
            e.printStackTrace();
        }

        String email;
        email = "example@mail.com"; //true
//        email = "example@mail.co"; //true
//        email = ".example.mail.com"; //false
//        email = "example.mail.com"; //false

        try {
            UserDataFormatHelper.emailChecker(email);
        } catch (StringFormatException e) {
            e.printStackTrace();
        }

        String birthDate;
        birthDate = "22/01/1995"; //true
//        birthDate = "22-01-1995"; //true
//        birthDate = "32/01/1995"; //false
//        birthDate = "22/13/1995"; //false

        try {
            UserDataFormatHelper.birthDateChecker(birthDate);
        } catch (StringFormatException e) {
            e.printStackTrace();
        }
    }
}
