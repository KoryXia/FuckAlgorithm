/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        this.queue.offer(x);
        for (int i = 1; i < this.queue.size(); i++) {
            this.queue.offer(this.queue.poll());
        }
    }
    
    public int pop() {
        return this.queue.poll();
    }
    
    public int top() {
        return this.queue.peek();
    }
    
    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

