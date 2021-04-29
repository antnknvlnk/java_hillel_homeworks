package lesson_twelve.deadlock;

public class SecondClass{
    synchronized void first(FirstClass firstClass) throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered the SecondClass.first");

        Thread.sleep(1000);

        System.out.println(name + " tries to call FirstClass.last");
        firstClass.last();
    }
    synchronized void last(){
        System.out.println("In method SecondClass.last");
    }
}
