package Revision;

import java.util.Arrays;

public class DP {
    public int rob(int[] nums) {
        /* int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(solve(0,nums,dp),solve(1,nums,dp));*/

        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = nums[i] + dp[i - 2];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    int minSquareNumber(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int step = 1 + minSquareNumber(n - (i * i), dp);
            min = Math.min(step, min);

        }
        dp[n] = min;
        return min;
    }

    int coinChange(int i, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (i >= coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }

        int nonPick = coinChange(i + 1, coins, amount);
        int pick = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            int next = coinChange(i, coins, amount - coins[i]);
            if (next != Integer.MAX_VALUE) {
                pick = 1 + next;
            }
        }
        return Math.min(pick, nonPick);
    }

    int minCoinChange(int i, int[] nums, int amount, int[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (i >= nums.length || amount < 0) {
            return Integer.MAX_VALUE;
        }
        int pick = Integer.MAX_VALUE;
        if (nums[i] <= amount) {
            int next = minCoinChange(i, nums, amount - nums[i], dp);
            if (next != Integer.MAX_VALUE) {
                pick = 1 + next;
            }

        }
        int nonPick = minCoinChange(i + 1, nums, amount, dp);
        return Math.min(pick, nonPick);
    }

    boolean equalPartition(int i, int[] nums, int sum, int[][] dp) {
        if (i == nums.length) {
            if (sum == 0) {
                return true;
            }
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean pick = false;
        if (nums[i] <= sum) {
            pick = equalPartition(i + 1, nums, sum - nums[i], dp);
        }
        boolean noPick = equalPartition(i + 1, nums, sum, dp);
        boolean ans = pick || noPick;
        dp[i][sum] = ans ? 1 : 0;
        return ans;
    }
    int solve(int i, int j, int n, int m, int[][] grid, int[][] dp) {
        if (i >= n || j >= m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = grid[i][j] + solve(i + 1, j, n, m, grid, dp);
        int right = grid[i][j] + solve(i, j + 1, n, m, grid, dp);
        dp[i][j] = Math.min(down, right);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, n, m, grid, dp);
    }
    public static void main(String[] args) {
        DP d = new DP();
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println("maximum amount after robbery: " + d.rob(nums));
        int n = 20;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("minimum square in number: " + d.minSquareNumber(n, dp));
        int[] coins = new int[]{1, 2, 5};
        System.out.println("minimum coins required for amount: " + d.coinChange(0, coins, 11));
        int amount = 11;
        int[][] dp1 = new int[coins.length][amount + 1];
        for (int[] arr : dp1) {
            Arrays.fill(arr, -1);
        }
        System.out.println("minimum coins required for amount: " + d.minCoinChange(0, coins, 11, dp1));
        // System.out.println("steps to reach n: "+d.stepsToReach(4));
        int[] nums1 = new int[]{1, 5, 11, 5};

        int sum = 0;
        for (int i : nums1) {
            sum += i;
        }

        if (sum % 2 != 0) {
            System.out.println("equal partition is not possible ");
        }
        sum = sum / 2;
        int[][] dp2 = new int[nums1.length][sum + 1];
        for (int[] arr : dp2) {
            Arrays.fill(arr, -1);
        }

        System.out.println("equal partition is not possible " + d.equalPartition(0, nums1, sum, dp2));
        int[][] grid=new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(d.minPathSum(grid));

    }
}
