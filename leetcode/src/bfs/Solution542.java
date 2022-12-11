package bfs;

import java.util.LinkedList;

public class Solution542 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] res = new int[m][n];
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            for (int[] direct : direction) {
                int x = cur[0] + direct[0];
                int y = cur[1] + direct[1];
                if (x > -1 && x < m && y > -1 && y < n && !visited[x][y]) {
                    queue.addLast(new int[]{x, y});
                    res[x][y] = res[cur[0]][cur[1]] + 1;
                    visited[x][y] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] res = new Solution542().updateMatrix(matrix);
        System.out.println(res);
    }
}
