package lesson_twelve.deadlock;

public class FirstClass{
    synchronized void first(SecondClass secondClass) throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered the FirstClass.first");

        Thread.sleep(1000);

        System.out.println(name + " tries to call SecondClass.last");
        secondClass.last();
    }
    synchronized void last(){
        System.out.println("In method FirstClass.last");
    }
}
