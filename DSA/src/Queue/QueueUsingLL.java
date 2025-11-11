package Queue;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}


class QueueLL {
    private Node front, rear;

    void enqueue(int data) {
        Node temp = new Node(data);
        if (rear == null) {
            temp = rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    int dequeue() {
        if (front == null) throw new RuntimeException("UnderFlow Expection");
        int val = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return val;
    }
}

public class QueueUsingLL {
}
