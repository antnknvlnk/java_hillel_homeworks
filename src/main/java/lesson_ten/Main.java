package lesson_ten;

import lesson_ten.functionalInterface.ConsumerInterface;
import lesson_ten.functionalInterface.FunctionInterface;
import lesson_ten.functionalInterface.PredicateInterface;
import lesson_ten.functionalInterface.SupplierInterface;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //PREDICATE

        PredicateInterface<Double> predicateSalary = salary -> salary >= 1500.0;
        System.out.println(predicateSalary.salary(1499.0));

        //CONSUMER

        ConsumerInterface<String> stringConsumerInterface = string -> {
            char[] chars = string.toCharArray();
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
        };
        stringConsumerInterface.stringToCharArray("Hello, world!");
        System.out.println();

        //FUNCTION

        FunctionInterface<Integer, String> intToStringWord = integer -> {
                switch (integer) {
                    case 1:
                        return "one";
                    case 2:
                        return "two";
                    case 3:
                        return "three";
                    case 4:
                        return "four";
                    case 5:
                        return "five";
                    case 6:
                        return "six";
                    case 7:
                        return "seven";
                    case 8:
                        return "eight";
                    case 9:
                        return "nine";
                    case 10:
                        return "ten";
                    }
                return "unknown";
            };
        System.out.println(intToStringWord.convert(-1));

        //SUPPLIER

        SupplierInterface<String> randomNumber = () ->  {
            int random = new Random().nextInt(100);
            return String.valueOf("Random number is: " + random);
        };
        System.out.println(randomNumber.get());
    }
}
