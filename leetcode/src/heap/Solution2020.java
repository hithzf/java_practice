package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 阿里巴巴笔试题
 * 二维数组，每行和每列都是从小到大排好序的，找出第K大的数
 * 关键点：最大堆
 */
public class Solution2020 {

    // 写了相当于没写
    public static int findKth(int[][] nums, int k) {
        int m = nums.length, n = nums[0].length;
        List<Integer> list = new ArrayList<>(m * n);
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                list.add(nums[i][j]);
            }
        }

        Collections.sort(list);
        return list.get(m * n - k);
    }

    // 不太好理解
    public static int findKthBetter(int[][] nums, int k) {
        int m = nums.length, n = nums[0].length;

        //维护每行目前为止最大的数
        int[] curMax = new int[m];
        //维护每行目前为止最大的数所在的下标
        int[] curMaxIndex = new int[m];
        for (int i = 0; i < nums.length; i++) {
            curMax[i] = nums[i][n - 1];
            curMaxIndex[i] = n - 1;
        }

        int count = 0;
        for (int i = m - 1; i > -1; ) {
            for (int j = n - 1; j > -1; ) {
                count++;
                if (count == k) {
                    return nums[i][j];
                }

                //curMax更新
                curMax[i] = nums[i][j - 1];
                curMaxIndex[i] = j - 1;

                //找到目前最大的数
                int tempMax = Integer.MIN_VALUE;
                for (int h = m - 1; h > -1; h--) {
                    if (curMax[h] > tempMax) {
                        i = h;
                        j = curMaxIndex[h];
                        tempMax = curMax[h];
                    }
                    if (curMaxIndex[h] == n - 1) {
                        break;
                    }
                }
            }
        }

        return -1;
    }

    // 推荐
    private static int findKthHeap(int[][] nums, int k) {
        // 最大堆，保存nums中最大的m个元素
        // 堆元素：{i, j, val}
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        int n = nums[0].length;
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, n - 1, nums[i][n - 1]});
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int[] max = queue.poll();
            if (count == k) {
                return max[2];
            }
            if (max[1] > 0) {
                queue.add(new int[]{max[0], max[1] - 1, nums[max[0]][max[1] - 1]});
            }
        }
        throw new IllegalArgumentException("Illegal argument:" + k);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4, 5},
                {2, 4, 5, 7, 10},
                {3, 9, 10, 11, 22},
                {6, 12, 22, 30, 44}};

        System.out.println(findKthBetter(nums, 5));
        System.out.println(findKthHeap(nums, 5));
    }
}
