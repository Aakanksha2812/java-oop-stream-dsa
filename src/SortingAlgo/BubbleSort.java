package SortingAlgo;

import static Print.PrintFunction.printArrayMethod;

public class BubbleSort {

    void bubbleSortAlgo(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] nums = new int[]{4, 2, 1, 3};
        b.bubbleSortAlgo(nums);
        printArrayMethod(nums);
        System.out.println();
    }
}
