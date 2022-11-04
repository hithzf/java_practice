package binary_tree;

/**
 * 注意非空判断
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes != null && rightRes != null) {
            return root;
        }
        return leftRes != null ? leftRes : rightRes;
    }
}
