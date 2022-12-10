package stack;

import java.util.Stack;

/**
 * 柱状图中的最大矩形
 * 单调栈
 */
public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        int[] newHeights = buildHeights(heights);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[i] < newHeights[stack.peek()]) {
                int cur = stack.pop();
                res = Math.max(res, newHeights[cur] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return res;
    }

    private int[] buildHeights(int[] heights) {
        int[] res = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            res[i + 1] = heights[i];
        }
        res[0] = 0;
        res[heights.length + 1] = 0;
        return res;
    }
}
