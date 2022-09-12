package queue_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {

    /**
     * 优先队列-超时
     * 时间复杂度O(nlogk)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[j++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            res[j++] = queue.peek();
        }
        return res;
    }

    /**
     * 单调队列
     * 时间复杂度O(n)
     */
    public int[] maxSlidingWindowBetter(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < k; i++) {
            pushDequeue(deque, nums[i]);
        }
        res[j++] = deque.getFirst();
        for (int i = k; i < nums.length; i++) {
            popDequeue(deque, nums[i - k]);
            pushDequeue(deque, nums[i]);
            res[j++] = deque.getFirst();
        }
        return res;
    }

    private void pushDequeue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.getLast() < num) {
            deque.removeLast();
        }
        deque.addLast(num);
    }

    private void popDequeue(Deque<Integer> deque, int num) {
        if (!deque.isEmpty() && deque.getFirst() == num) {
            deque.removeFirst();
        }
    }
}
