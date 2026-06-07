package Stack;

import java.util.Stack;

public class stackImplementation {
    int[] arr;
    int top;

    stackImplementation(int size) {
        arr = new int[size];
        top = -1;
    }

    void push(int x) {
        top++;
        arr[top] = x;
    }

    int pop() {
        return arr[top--];
    }

    int peek() {
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }

    void printStack(Stack<Integer> stack) {

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    boolean isBalanceParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int peek = st.pop();
        insertAtBottom(st, x);
        st.push(peek);
    }

    void reverseStack(Stack<Integer> st) {
        while (!st.isEmpty()) {

            int peek = st.pop();
            insertAtBottom(st, peek);
        }
    }

    void sortStack(Stack<Integer> st, Stack<Integer> temp) {

        if (st.isEmpty()) {
            return;
        }

        temp.push(st.pop());

        while (!st.isEmpty()) {
            int pop = st.pop();

            while (!temp.isEmpty() && pop < temp.peek()) {
                st.push(temp.pop());
            }

            temp.push(pop);
        }

        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

    }

    public static void main(String[] args) {
        stackImplementation s = new stackImplementation(6);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("pop element from stack: " + s.pop());
        System.out.println("peek element is: " + s.peek());
        System.out.println("is stack empty: " + s.isEmpty());
        System.out.println("reverse String is: " + s.reverseString("AAKANKSHA"));
        System.out.println();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = 1;
        Stack<Integer> stack = new Stack<>();
        while (i <= 5) {
            stack.push(i);
            i++;
        }
        s.printStack(stack);
        System.out.println();
        String parentheses = "(()()";
        System.out.println("is parentheses balanced: " + s.isBalanceParentheses(parentheses));
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        s.insertAtBottom(st, 5);
        s.printStack(st);
        System.out.println();
        st.push(10);
        st.push(20);
        st.push(30);
        Stack<Integer> d = new Stack<>();
        s.reverseStack(st);
        s.printStack(st);
        d.push(10);
        d.push(30);
        d.push(5);
        d.push(20);
        Stack<Integer> temp = new Stack<>();
        s.sortStack(d, temp);
        s.printStack(d);

    }
}
