package lesson_nine.service;

public interface ThirdInterface extends  FirstInterface{
    default void defaultPrint(String string){
        System.out.println("ThirdInterface " + string);
    };

    static void printRandomNumber(){
        System.out.println((int) (Math.random() * 100));
    }

    boolean check();

    void print();
}
