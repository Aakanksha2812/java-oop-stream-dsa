package Searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

public class LeetcodeQuestions {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            int temp = arr[i] * 2;
            if (temp == arr[j]) {
                return true;
            }
            if (temp < arr[j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

    public boolean checkIfExist1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            System.out.println(arr[i] / 2.0);
            if (set.contains(arr[i] * 2) || set.contains(arr[i] / 2.0)) {
                return true;
            }
        }
        return false;
    }

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        System.out.println(nums);
        int count = 0;
        int i = 0;
        int j = nums.size() - 1;
        while (i <= j) {
            if (nums.get(i) + nums.get(j) < target) {
                count++;

            }
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetcodeQuestions l = new LeetcodeQuestions();
        int[] arr = new int[]{7, 15, 3, 4, 30};
        // System.out.println(l.checkIfExist(arr));
        System.out.println(l.checkIfExist1(arr));
        List<Integer> nums = asList(-1, 1, 2, 3, 1);
        System.out.println(l.countPairs(nums, 2));
    }
}
