package SortingAlgo;

import static Print.PrintFunction.printArrayMethod;

public class SelectionSort {
    void selectionSortAlgo(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[minIndex];
            nums[minIndex]=temp;

        }
    }
    public static void main(String[] args) {
       SelectionSort s=new SelectionSort();
        int[] nums = new int[]{4, 2, 1, 3};
       s.selectionSortAlgo(nums);
        printArrayMethod(nums);
        System.out.println();
    }
}
