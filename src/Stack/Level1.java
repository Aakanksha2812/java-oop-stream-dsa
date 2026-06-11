package Stack;

import java.util.SortedMap;
import java.util.Stack;

import static Print.PrintFunction.printArrayMethod;

public class Level1 {
    int[] nextGreaterElement(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for (int i : nums2) {
            st1.push(i);
        }
        for (int i = 0; i < n; i++) {

            while (!st1.isEmpty() && nums1[i] != st1.peek()) {
                st2.push(st1.pop());
            }
            while (!st2.isEmpty() && nums1[i] >= st2.peek()) {
                st1.push(st2.pop());
            }
            if (st2.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st2.peek();
            }
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }
        return ans;
    }
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] temp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                temp[i] = -1;
            } else {
                temp[i] = st.peek();
            }
            st.push(nums[i]);
        }
        while (!st.isEmpty() && st.peek() <= nums[n-1]) {
           st.pop();
        }
        if(!st.isEmpty()){
            temp[n-1]=st.peek();
        }
        return temp;
    }
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (String o : operations) {

            if (o.equals("+")) {
                int top = st.pop();
                int newScore = top + st.peek();
                st.push(top);
                st.push(newScore);
            } else if (o.equals("D")) {

                st.push(2 * st.peek());
            } else if (o.equals("C")) {
                st.pop();
            } else {
                int num = Integer.parseInt(o);

                st.push(num);
            }
        }
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }
            if (st.empty()) {
                ans[i] = prices[i];
            } else {
                ans[i] = prices[i] - st.peek();
            }
            st.push(prices[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Level1 l = new Level1();
        int[] arr = new int[]{1, 3, 2, 4};
        int[] ans = l.nextGreaterElement(arr);
        printArrayMethod(ans);
        System.out.println();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] ans2 = l.nextGreaterElement(nums1, nums2);
        printArrayMethod(ans2);
        System.out.println();
        String[] ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("final ans of opration: " + l.calPoints(ops));
        int[] num=new int[]{1,2,1};
        int[] ans3=l.nextGreaterElements(num);
        printArrayMethod(ans3);
        System.out.println();
        int[] prices=new int[]{8,7,4,2,8,1,7,7,10,1};
        int[] ans4=l.finalPrices(prices);
        printArrayMethod(ans4);
    }
}
