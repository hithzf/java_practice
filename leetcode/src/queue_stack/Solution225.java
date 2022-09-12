package queue_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈
 */
public class Solution225 {

    public static class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * O(n)
         */
        public void push(int x) {
            queue.add(x);
            int len = queue.size(), i = 0;
            while (i++ < len - 1) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.element();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
