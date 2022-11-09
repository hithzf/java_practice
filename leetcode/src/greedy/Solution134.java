package greedy;

/**
 * 如何能想到
 */
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += (gas[i] - cost[i]);
            curSum += (gas[i] - cost[i]);
            if (curSum < 0) {
                curSum = 0;
                start = i + 1;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
