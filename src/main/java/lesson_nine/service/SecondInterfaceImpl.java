package lesson_nine.service;

public class SecondInterfaceImpl implements SecondInterface, FourthInterface{

    @Override
    public void defaultPrint(String string) {
        System.out.println("InterfaceImpl " + string);
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void print() {
        System.out.println("second prnt");
    }
}
