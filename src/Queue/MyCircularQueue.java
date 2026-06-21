package Queue;

class MyCircularQueue {
    int front;
    int rear;
    int[] arr;
    int capacity;

    public MyCircularQueue(int k) {
        capacity = k+1;
        front = 0;
        rear = 0;
        arr = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;

    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        return front;
    }

    public int Rear() {
        return rear;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        if ((rear + 1) % capacity == front) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);

        System.out.println(q.enQueue(10));
        System.out.println(q.enQueue(20));
        System.out.println(q.enQueue(30));
        System.out.println(q.enQueue(40));
        System.out.println(q.rear);
        System.out.println(q.isFull());
        System.out.println(q.deQueue());
        System.out.println(q.enQueue(40));
        System.out.println(q.rear);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */