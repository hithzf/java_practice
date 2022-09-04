package array;

/**
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.md
 */
public class Solution209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, res = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

