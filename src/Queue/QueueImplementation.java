package Queue;

public class QueueImplementation {

    int capacity;
    int front;
    int rear;
    int[] arr;


    QueueImplementation(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;

        rear = -1;
    }

    void enqueue(int x) {
        if (rear == capacity - 1) {
            System.out.println("queue is full!!");
            return;
        }
        rear++;
        arr[rear] = x;
    }

    int dequeue() {

        if (front > rear) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front++];
    }

    boolean isEmpty() {
        if (front > rear) {
            return true;
        }
        return false;
    }

    int peek() {
        if (front > rear) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return arr[front];
    }

    void print() {
        for (int i = front; i <= rear ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        QueueImplementation q = new QueueImplementation(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.print();
    }
}
