package lesson_nine.service;

public class FirstInterfaceImpl implements FirstInterface, ThirdInterface {

    @Override
    public boolean check() {
        return true;
    }

    @Override
    public void print() {
        System.out.println("print");
    }
}
