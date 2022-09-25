package binary_tree;

public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            return countNodes(root.right) + (1 << leftLevel);
        } else {
            return countNodes(root.left) + (1 << rightLevel);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }
        return level;
    }
}
