package SortingAlgo;

import java.util.ArrayList;

import static Print.PrintFunction.printArrayMethod;

public class MergeSort {
    void mergeSortAlgo(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortAlgo(arr, low, mid);
        mergeSortAlgo(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    public static void main(String[] args){
        MergeSort m=new MergeSort();
        int[] nums = new int[]{4, 2, 1, 3};
        m.mergeSortAlgo(nums,0,nums.length-1);
        printArrayMethod(nums);
    }
}
