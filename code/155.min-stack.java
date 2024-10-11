/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;
    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
        this.minStack.addFirst(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        this.stack.addFirst(val);
        this.minStack.addFirst(Math.min(this.minStack.getFirst(), val));
    }
    
    public void pop() {
        this.stack.removeFirst();
        this.minStack.removeFirst();
    }
    
    public int top() {
        return this.stack.getFirst();
    }
    
    public int getMin() {
        return this.minStack.getFirst();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

