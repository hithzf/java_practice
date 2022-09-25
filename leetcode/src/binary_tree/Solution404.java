package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution404 {

    // 广度优先
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.left != null && isLeaf(cur.left)) {
                res += cur.left.val;
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return res;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
