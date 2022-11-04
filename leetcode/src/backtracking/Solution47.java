package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0047.%E5%85%A8%E6%8E%92%E5%88%97II.md
 */
public class Solution47 {
    private final List<List<Integer>> res = new ArrayList<>();
    private final LinkedList<Integer> trace = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            trace.addLast(nums[i]);
            backtracking(nums, used);
            trace.removeLast();
            used[i] = false;
        }
    }
}
