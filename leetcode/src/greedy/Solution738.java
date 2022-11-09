package greedy;

/**
 * 首先是想通这个算法，其次是代码实现
 */
public class Solution738 {

    public int monotoneIncreasingDigits(int n) {
        char[] array = String.valueOf(n).toCharArray();
        int flag = array.length;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] > array[i]) {
                array[i - 1]--;
                flag = i;
            }
        }
        for (int i = flag; i < array.length; i++) {
            array[i] = '9';
        }
        return Integer.valueOf(String.valueOf(array));
    }
}
