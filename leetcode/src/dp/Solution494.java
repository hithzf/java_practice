package dp;

import java.util.stream.IntStream;

/**
 * 1.如何转化为背包问题
 * 2.装满背包有几种方法问题
 */
public class Solution494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = IntStream.of(nums).sum();
        if (sum < Math.abs(target)) {
            return 0;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int goal = (target + sum) / 2;
        int[] dp = new int[goal + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = goal; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[goal];
    }
}
