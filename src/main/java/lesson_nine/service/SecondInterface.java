package lesson_nine.service;

public interface SecondInterface {
    default void defaultPrint(String string){
        System.out.println("SecondInterface " + string);
    };

    static void toUpperCase (String string){
        System.out.println(string.toUpperCase());
    }

    boolean check();

    void print();
}
