package sort;

/**
 * 归并排序算法的应用
 */
public class Offer51 {

    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start == end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        return mergeSort(nums, start, mid, temp) + mergeSort(nums, mid + 1, end, temp) + merge(nums, start, mid, end, temp);
    }

    private int merge(int[] nums, int start, int mid, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int i = start, j = mid + 1;
        int count = 0;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > end) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
