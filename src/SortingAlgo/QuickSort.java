package SortingAlgo;

import static Print.PrintFunction.printArrayMethod;

public class QuickSort {
    void quickSortAlgo(int[] arr,int low,int high){
        if (low>=high){
            return;
        }
        int part=partition(arr,low,high);

        quickSortAlgo(arr,low,part-1);
        quickSortAlgo(arr,part+1,high);
    }
    int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while (i<j){
            while (i<=high && arr[i]<=pivot){
                i++;
            }
            while (j>=0 && arr[j]>pivot){
                j--;
            }
            if (i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }
    public static void main(String[] args){
       QuickSort q=new QuickSort();
        int[] nums = new int[]{4,6,2,5,1};
       q.quickSortAlgo(nums,0,nums.length-1);
        printArrayMethod(nums);
    }
}
