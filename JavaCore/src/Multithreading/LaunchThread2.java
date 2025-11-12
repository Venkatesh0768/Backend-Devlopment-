package Multithreading;

import java.util.Scanner;

class Banking extends Thread{
    @Override
    public void run(){
        banking();
    }
    public void banking(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user name");
        int n = sc.nextInt();
        System.out.println("Enter the password");
        int as = sc.nextInt();
        System.out.println(n + " " +  as);
    }
}


class PrintStars extends Thread{
    @Override
    public void run() {
        try {
            printStars();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printStars() throws InterruptedException {
        for (int i=0; i<=4 ; i++){
            System.out.println("* ");
            Thread.sleep(2000);
        }
    }
}

class Focus  extends Thread{
    @Override
    public void run() {
        try {
            focus();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void focus() throws InterruptedException {
        for (int i=0; i<=4 ; i++){
            System.out.println("Fucking it Happened");
            Thread.sleep(2000);
        }
    }

}
public class LaunchThread2 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("System is Stated ...............................................");
       Banking a = new Banking();
       PrintStars b = new PrintStars();
       Focus c = new Focus();

       a.start();
       a.join();
       b.start();
       c.start();
       b.join();
       c.join();
        System.out.println("System is Completed ...............................................");
    }
}
