package greedy;

public class Solution55 {

    // 有理解成本
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        return myJump(nums, 0);
    }

    private boolean myJump(int[] nums, int start) {
        if (nums[start] >= nums.length - 1 - start) {
            return true;
        }
        boolean flag = false;
        for (int i = nums[start]; i > 0; i--) {
            //����ʧ��
            if (i != nums[start] && nums[start + i] - nums[start + i + 1] <= 1) {
                continue;
            }
            flag = flag || myJump(nums, start + i);
            //���ٳɹ�
            if (flag) {
                return flag;
            }
        }
        return flag;
    }

    // 更容易理解，但是还有时间复杂度更优的解法
    public boolean canJump2022(int[] nums) {
        int n = nums.length;
        // 保存该位置能跳到的最远位置
        int[] distance = new int[n];
        // 从后往前计算distance[]
        for (int i = n - 1; i > -1; i--) {
            int far = i; // 每个点最初都只能跳到自己的位置
            for (int j = i + 1; j < n && j <= i + nums[i]; j++) {
                far = Math.max(far, distance[j]); // 最远能跳到的位置
            }
            distance[i] = far;
        }
        return distance[0] == n - 1;
    }

    public static void main(String[] args) {
        Solution55 ins = new Solution55();
        int[] nums = {3, 2, 10, 0, 4, 7, 9, 8, 10, 2, 6, 100, 1};
        long start = System.currentTimeMillis();
        System.out.println(ins.canJump(nums) + ":*****" + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        System.out.println(ins.canJump2022(nums) + ":*****" + (System.currentTimeMillis() - start2));
    }
}
