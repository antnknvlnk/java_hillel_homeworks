package lesson_nine;

import lesson_nine.service.*;
import lesson_nine.utill.Helper;

import java.io.IOException;

public class Main {
    private static Object IOException;

    public static void main(String[] args) throws IOException {
        FirstInterfaceImpl firstInterfaceImpl = new FirstInterfaceImpl();
        SecondInterfaceImpl secondInterface = new SecondInterfaceImpl();

        FirstInterface.printSum(2, 3);
        firstInterfaceImpl.check();
        firstInterfaceImpl.defaultPrint("Test string");
        firstInterfaceImpl.print();

        SecondInterface.toUpperCase("some string value");
        secondInterface.check();
        secondInterface.defaultPrint("SecondInterfaceImpl");
        secondInterface.print();

        ThirdInterface.printRandomNumber();

        FourthInterface.checkNumber(12);

        Helper helper = new Helper();
        System.out.println(helper.optionalHelper("anton@mail.ua"));
        System.out.println(helper.optionalHelper("a a"));

        System.out.println(helper.optionalHelper("anton @ mail.ua").orElseThrow(java.io.IOException::new));

    }
}
