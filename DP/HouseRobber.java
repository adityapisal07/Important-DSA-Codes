package DP;
import java.util.Arrays;

class HouseRobber {

    // Simple recursion
    public int solve(int[] nums, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return nums[0];
        }

        int incl = solve(nums, n - 2) + nums[n];
        int excl = solve(nums, n - 1);

        return Math.max(incl, excl);
    }

    // Recursion with memoization
    public int solveMemo(int[] nums, int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return nums[0];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int incl = solveMemo(nums, n - 2, dp) + nums[n];
        int excl = solveMemo(nums, n - 1, dp);

        dp[n] = Math.max(incl, excl);
        return dp[n];
    }

    // Tabulation (Bottom-up DP)
    public int solvetab(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    // Main rob method
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // return solveMemo(nums, n - 1, dp); // Using memoization
        return solvetab(nums); // Using tabulation (efficient)
    }

    // Main method
    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] houses = {2, 7, 9, 3, 1};

        int maxRob = solution.rob(houses);
        System.out.println("Maximum amount that can be robbed: " + maxRob);
    }
}
