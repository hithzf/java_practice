package greedy;

import java.util.Arrays;

public class Solution135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] <= ratings[i - 1]) {
                candies[i] = 1;
            } else {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }
        return Arrays.stream(candies).sum();
    }
}
