package Queue;

import java.util.Stack;

public class QueueImplementation {

    int capacity;
    int front;
    int rear;
    int[] arr;
    Stack<Integer> st1;
    Stack<Integer> st2;


    QueueImplementation(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        st1 = new Stack<>();
        st2 = new Stack<>();
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
        for (int i = front; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    void enqueueStack(int x) {
        st1.push(x);
    }

    int dequeueStack() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int val = st2.pop();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return val;
    }

    int peekStack() {

        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        int val = st2.peek();

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }

        return val;
    }

    boolean isEmptyQueue() {
        return st1.isEmpty();
    }

    void printQueueUsingStack() {

        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        while (!st2.isEmpty()) {
            int val = st2.pop();
            System.out.println(val);
            st1.push(val); 
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
        q.enqueueStack(10);
        q.enqueueStack(20);
        q.enqueueStack(30);
        q.enqueueStack(40);
        q.dequeueStack();
        q.printQueueUsingStack();
    }
}
