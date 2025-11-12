package Multithreading;

class Producer extends Thread {
    Queue q;
    int i = 0;
    public Producer(Queue i) {
        this.q = i;
    }
    @Override
    public void run() {
        while (true) {
           if(i == 5){

           }
            q.produce(i++);
        }
    }

}

class Consumer extends Thread{
    Queue q;
    public Consumer(Queue i) {
        this.q = i;
    }
    @Override
    public void run() {
        while (true) {
            q.consume();
        }
    }
}

class Queue {
    int data;
    boolean flag = false;


    synchronized public void produce(int i) {
        try {
            while (flag) {
                wait(); // wait until data is consumed
            }
            data = i;
            System.out.println("Producer produced: " + data);
            flag = true;
            notify(); // wake up consumer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void consume() {
        try {
            while (!flag) {
                wait(); // wait until data is produced
            }
            System.out.println("Consumer consumed: " + data);
            flag = false;
            notify(); // wake up producer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

public class InterThread {
    public static void main(String[] args) {
        Queue q = new Queue();
        Producer p1 = new Producer(q);
        Consumer p2 = new Consumer(q);

        p1.start();
        p2.start();


    }
}
