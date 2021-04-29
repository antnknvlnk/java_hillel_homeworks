package lesson_twelve.util;

import lesson_four.exceptions.StringFormatException;
import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class TestClass {
    public static int value = 0;

    public static int incrementNumber(){
        System.out.println("Current Thread name: " + Thread.currentThread().getName() + ", value = " + value);
        return value++;
    }
}
