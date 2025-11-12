package Multithreading;

import com.sun.source.tree.SynchronizedTree;

class Car extends  Thread{
    @Override
    synchronized public void run(){
       try {
           System.out.println(Thread.currentThread().getName() + " entered the Parking lot " );
           Thread.sleep(2000);

           System.out.println( Thread.currentThread().getName() + " entered the car lot " );
           Thread.sleep(2000);
           System.out.println( Thread.currentThread().getName() + " leave the Parking lot " );
           Thread.sleep(2000);
           System.out.println( Thread.currentThread().getName() + " come Back to the Parking lot " );
           System.out.println();
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}

public class Launchsynchronized {
    public static void main(String[] args) {

        Car car = new Car();
        Thread t1 = new Thread(car);
        Thread t2 = new Thread(car);
        Thread t3 = new Thread(car);

        System.out.println(t1.getState());

        t1.setName("Remesh");
        t2.setName("Venky");
        t3.setName("Suresh");

        t1.start();
        System.out.println(t1.getState());
    }
}
