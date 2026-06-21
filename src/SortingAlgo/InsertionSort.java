package SortingAlgo;

import static Print.PrintFunction.printArrayMethod;

public class InsertionSort {

    void insertionSortAlgo(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        int[] nums = new int[]{4, 2, 1, 3};
        i.insertionSortAlgo(nums);
        printArrayMethod(nums);
        System.out.println();
    }

}

