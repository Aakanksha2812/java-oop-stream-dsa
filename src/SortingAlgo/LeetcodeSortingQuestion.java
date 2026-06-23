package SortingAlgo;

import java.util.ArrayList;
import java.util.Arrays;

import static Print.PrintFunction.printArrayMethod;

public class LeetcodeSortingQuestion {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < m + n && j < n && i < m) {
            if (nums1[i] > nums2[j]) {
                ans[k] = nums2[j];
                j++;
            } else {
                ans[k] = nums1[i];
                i++;
            }
            k++;

        }
        while (j < n && k < m + n) {

            ans[k] = nums2[j];
            j++;
            k++;
        }
        while (i < m && k < m + n) {

            ans[k] = nums1[i];
            i++;
            k++;
        }
        for(int a=0;a<m+n;a++){
            nums1[a]=ans[a];
        }
    }
    void threeSubsequnces(int i, int[] nums, int prod, ArrayList<Integer> list){
        if(i>nums.length){
            return;
        }
    }

    public static void main(String[] args) {
        LeetcodeSortingQuestion l = new LeetcodeSortingQuestion();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        l.merge(nums1, 0, nums2, 1);
        printArrayMethod(nums1);
        System.out.println();
    }
}
