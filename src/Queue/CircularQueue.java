package Queue;

public class CircularQueue {
    int front;
    int rear;
    int capacity;
    int[] arr;

    CircularQueue(int capacity) {
        this.capacity = capacity + 1;
        front = 0;
        rear = 0;
        arr = new int[this.capacity];
    }

    void enqueue(int x) {
        if ((rear + 1) % capacity == front) {
            System.out.println("Queue is full!");
            return;
        }
        arr[rear] = x;

        rear = (rear + 1) % capacity;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        return val;
    }

    boolean isEmpty() {
        return front == rear;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return arr[front];
    }

    void print() {
        int i = front;
        while (i != rear) {
            System.out.println(arr[i]);
            i = (i + 1) % capacity;
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.print();
    }
}
