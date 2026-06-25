package SortingAlgo;

import java.util.*;

import static Print.PrintFunction.printArrayMethod;

public class LeetcodeQuestion {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        List<Integer> list=new ArrayList<>(set);
        System.out.println(list);
        for (int i = 0; i < n; i++) {
            int idx=list.indexOf(arr[i]);
            ans[i]=idx+1;
        }
        return ans;
    }
    public static void main(String[] args){
        LeetcodeQuestion l=new LeetcodeQuestion();
        int[] arr=new int[]{40,10,20,30};
       int[] ans= l.arrayRankTransform(arr);
        printArrayMethod(ans);
        System.out.println();
    }
}
