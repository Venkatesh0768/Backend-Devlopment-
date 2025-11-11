package Queue;

//Using Array/

class QueueArr {
    private int[] arr;
    private int front, rear, size, capcity;

    QueueArr(int capcity) {
        this.capcity = capcity;
        arr = new int[capcity];
        front = size = 0;
        rear = capcity - 1;
    }


    boolean isFull() {
        return size == capcity - 1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {
        if (isFull()) throw new RuntimeException("Queue is Full");
        rear = (rear + 1) % capcity;
        arr[rear] = data;
        size++;
    }

    int dequeue(){
        if (isEmpty()) throw new RuntimeException("Queue is Underflow");
        int val = arr[front];
        front = (front + 1 ) % capcity;
        size--;
        return val;
    }

    int front(){
        return arr[front];
    }
}

public class QueueImpl {
    public static void main(String[] args) {
        QueueArr  qs = new QueueArr(10);
        qs.enqueue(20);
        qs.enqueue(10);
        qs.enqueue(30);
        qs.enqueue(80);
        qs.enqueue(60);

        while (!qs.isEmpty()){
            System.out.println(qs.dequeue());

        }
    }
}
