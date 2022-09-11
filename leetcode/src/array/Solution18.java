package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 注意超过int最大值
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    long sum = (long) nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum > target) {
                        n--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        res.add(Stream.of(nums[i], nums[j], nums[m], nums[n]).collect(Collectors.toList()));
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        m++;
                        n--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        Solution18 solution = new Solution18();
        System.out.println(solution.fourSum(nums, -294967296));
    }
}
