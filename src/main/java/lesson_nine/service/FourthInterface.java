package lesson_nine.service;

public interface FourthInterface {
    default void defaultPrint(String string){
        System.out.println("FourthInterface " + string);
    };

    static boolean checkNumber (int number) {
        return number > 0;
    }

    boolean check();

    void print();
}
