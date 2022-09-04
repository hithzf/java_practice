package array;

public class Solution59 {

    public int[][] generateMatrix(int n) {
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][n];
        int cur = 1, circle = 0;
        while (circle < n / 2) {
            int i = circle, j = circle;
            for (int[] index : direct) {
                for (int k = circle; k < n - circle - 1; k++) {
                    res[i][j] = cur++;
                    i = i + index[0];
                    j = j + index[1];
                }
            }
            circle++;
        }
        if (n % 2 == 1) {
            res[circle][circle] = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution59 solution = new Solution59();
        solution.generateMatrix(4);
    }
}
