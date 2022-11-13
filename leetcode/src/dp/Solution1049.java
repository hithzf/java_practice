package dp;

import java.util.stream.IntStream;

/**
 * 和416异曲同工
 */
public class Solution1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
