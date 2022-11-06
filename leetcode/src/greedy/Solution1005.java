package greedy;

import java.util.Arrays;

/**
 * 容易想错，误认为多出来的k如果是奇数则直接将最小的正数取相反数
 */
public class Solution1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int minAbs = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = (-nums[i]);
                k--;
            }
            if (Math.abs(nums[i]) < minAbs) {
                minAbs = Math.abs(nums[i]);
                minIndex = i;
            }
        }
        if (k % 2 == 1) {
            nums[minIndex] = -(nums[minIndex]);
        }
        return Arrays.stream(nums).sum();
    }
}
