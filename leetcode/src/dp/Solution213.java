package dp;

public class Solution213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        return Math.max(myRob(nums, 0, len - 1), myRob(nums, 1, len));
    }

    private int myRob(int[] nums, int start, int end) {
        if (start + 1 == end) {
            return nums[start];
        }
        int[] dp = new int[end];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end - 1];
    }
}
