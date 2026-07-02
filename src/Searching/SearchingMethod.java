package Searching;

 class SearchingMethod {
    int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    int firstOccuranceOfTargetBS(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                idx = mid;

              high = mid - 1;
              //  low=mid+1;

            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
     public int[] searchRange(int[] nums, int target) {
         int first = -1;
         int second = -1;
         int left = 0;
         int right = nums.length - 1;
         while (left <= right) {
             if (nums[left] == target) {
                 first = left;
             }
             if (nums[right] == target) {
                 second = right;
             }
             left++;
             right--;
         }
         return new int[] { first, second };
     }
    public static void main(String[] args) {
        SearchingMethod s = new SearchingMethod();
        int[] nums = new int[]{1, 9, 10, 100, 450, 1000, 6700};
        System.out.println("index found at this position: " + s.binarySearch(nums, 9));
        int[] nums2 = new int[]{1, 2, 4, 4, 4, 4, 7, 9};
        int target = 4;
        System.out.println("first occurnace of index is: " + s.firstOccuranceOfTargetBS(nums2, target));
    }
}
