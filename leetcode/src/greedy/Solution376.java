package greedy;

/**
 * 题目不难，但要一把过不简单
 * 注意：差值为0的处理
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int res = 1, pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] && pre >= 0 || nums[i] > nums[i - 1] && pre <= 0) {
                res++;
                pre = nums[i] - nums[i - 1];
            }
        }
        return res;
    }
}
