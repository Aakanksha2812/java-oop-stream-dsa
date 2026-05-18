package Array;

public class Level1 {
    public int findLengthOfLCIS(int[] nums) {
        int s = 0;
        int e = nums.length-1 ;
        while (s < e) {
            if (nums[s] < nums[e]) {
                s++;
                e--;
            } else if (nums[s] > nums[e]) {
                s++;
            } else {
                e--;
            }
        }
        return s+1;
    }
    public static void main(String[] args){
        Level1 l=new Level1();
        int[] nums=new int[]{1,3,5,4,7};
        System.out.println(l.findLengthOfLCIS(nums));
    }
}
