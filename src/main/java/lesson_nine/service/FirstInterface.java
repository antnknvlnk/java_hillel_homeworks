package lesson_nine.service;

public interface FirstInterface {
    default void defaultPrint(String string){

    };

    static void printSum (int a, int b){
        System.out.println("a + b = " + a + b);
    };

    boolean check();

    void print();
}
