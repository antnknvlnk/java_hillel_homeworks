package lesson_four.utils;

import lesson_four.exceptions.StringFormatException;

public class StringOperationsHelper {

    public static String stringOperations(String string, char[] arr) throws StringFormatException {
        String charToString = null;
        try {
            if (arr.length != 0) {
                charToString = String.valueOf(arr);
                System.out.println("charToString: " + charToString);
            }
        } catch (NullPointerException e) {
            System.out.println("Error. There are no symbols in array");
        }

        assert charToString != null;
        if (string.trim().isEmpty() || charToString.trim().isEmpty()) {
            System.out.println("Invalid input");
            throw new StringFormatException();
        }

        string = string.trim();
        charToString = charToString.trim();

        string = string.toUpperCase();
        charToString = charToString.toLowerCase();

        String newString = string.concat(" ").concat(charToString);
        System.out.println("newString: " + newString);

        String substring;

        if (newString.length() % 2 == 0) {
            int pos1 = (newString.length() / 2) - 1;
            int pos2 = (newString.length() / 2) + 1;
            substring = newString.substring(0, pos1);
            substring += newString.substring(pos2);
        } else {
            double pos1 = Math.floor((newString.length() >> 1) - 1);
            double pos2 = Math.ceil((newString.length() >> 1) + 1);
            substring = newString.substring(0, (int) pos1);
            substring += newString.substring((int) pos2);
        }
        return substring;
    }
}
