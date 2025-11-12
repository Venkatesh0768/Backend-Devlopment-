package Multithreading;

public class LaunchThread1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println("First");
        Thread.sleep(2000);
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println("Second");
    }
}
