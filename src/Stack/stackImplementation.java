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

    void printStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            stack.push(arr[i]);
            i++;
        }
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
    void insertAtBottom(Stack<Integer> st, int x){

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
        s.printStack(arr);
        String parentheses = "(()()";
        System.out.println("is parentheses balanced: "+s.isBalanceParentheses(parentheses));
    }
}
