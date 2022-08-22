package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution57 {

    /**
     * 太多if-else，不容易理解
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Node> list = new LinkedList<>();
        Node intervalNode = new Node(newInterval[0], newInterval[1]);
        list.add(intervalNode);
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[1] < newInterval[0]) {
                list.add(list.size() - 1, new Node(cur[0], cur[1]));
            } else if (cur[0] > newInterval[1]) {
                list.add(new Node(cur[0], cur[1]));
            } else if (cur[0] >= newInterval[0] && cur[1] <= newInterval[1]) {
                continue;
            } else if (cur[0] <= newInterval[0] && cur[1] >= newInterval[1]) {
                intervalNode.setLeft(cur[0]);
                intervalNode.setRight(cur[1]);
            } else if (cur[0] <= newInterval[1] && cur[1] > newInterval[1]) {
                intervalNode.setRight(cur[1]);
                newInterval[1] = cur[1];
            } else {
                intervalNode.setLeft(cur[0]);
                newInterval[0] = cur[0];
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).getLeft();
            res[i][1] = list.get(i).getRight();
        }
        return res;
    }

    /**
     * 同样需要一些理解成本
     */
    public int[][] insert2022(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        // 找到要插入的位置
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // 新区间的起点
        int begin = (i == intervals.length) ? newInterval[0] : Math.min(intervals[i][0], newInterval[0]);
        // 找到第一个大于newInterval[1]的
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            i++;
        }
        int end = (i == 0) ? newInterval[1] : Math.max(newInterval[1], intervals[i - 1][1]);
        res.add(new int[]{begin, end});
        // 处理后续的点
        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }

        int[][] arrRes = new int[res.size()][];
        for (int j = 0; j < res.size(); j++) {
            arrRes[j] = res.get(j);
        }
        return arrRes;
    }

    public static void main(String[] args) {
        Solution57 solution = new Solution57();
        int[][] arg1 = {{2, 6}, {20, 21}};
        int[] arg2 = {3, 19};
        int[][] res = solution.insert(arg1, arg2);
        int[][] res2022 = solution.insert2022(arg1, arg2);
        System.out.println(isEqual(res, res2022));
    }

    private static boolean isEqual(int[][] res, int[][] res2022) {
        int m = res.length, n = res[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] != res2022[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    class Node {
        private int left;
        private int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}
