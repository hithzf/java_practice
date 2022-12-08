package sort;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int res1 = findLeft(nums, target, mid);
                int res2 = findRight(nums, target, mid);
                return new int[]{res1, res2};
            }
        }
        return new int[]{-1, -1};
    }

    private int findLeft(int[] nums, int target, int right) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int findRight(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // 注意这个地方
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
