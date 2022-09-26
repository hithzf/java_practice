package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯
 */
public class Solution113 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> track = new LinkedList<>();
        backtracking(root, track, targetSum);
        return res;
    }

    private void backtracking(TreeNode root, LinkedList<Integer> track, int targetSum) {
        if (root == null) {
            return;
        }
        track.add(root.val);
        if (isLeaf(root) && targetSum == root.val) {
            res.add(new ArrayList<>(track));
        }
        backtracking(root.left, track, targetSum - root.val);
        backtracking(root.right, track, targetSum - root.val);
        track.removeLast();
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
