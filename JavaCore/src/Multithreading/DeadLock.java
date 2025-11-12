package Multithreading;

public class DeadLock {
    public static void main(String[] args) {
        LibraryManagement ls = new LibraryManagement();
        Thread t1 = new Thread(ls);
        Thread t2 = new Thread(ls);
        t1.setName("Student1");
        t2.setName("Student2");
        t1.start();
        t2.start();

    }
}
