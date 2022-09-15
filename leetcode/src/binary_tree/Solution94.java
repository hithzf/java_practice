package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {

    /**
     * 中序遍历，不使用递归的通用解法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(new MyTreeNode(root, false));
        while (!stack.isEmpty()) {
            MyTreeNode cur = stack.pop();
            if (cur.node == null) {
                continue;
            }
            if (cur.visited) {
                res.add(cur.node.val);
            } else {
                stack.push(new MyTreeNode(cur.node.right, false));
                stack.push(new MyTreeNode(cur.node, true));
                stack.push(new MyTreeNode(cur.node.left, false));
            }
        }
        return res;
    }

    public static class MyTreeNode {
        TreeNode node;
        boolean visited;

        MyTreeNode(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }
}
