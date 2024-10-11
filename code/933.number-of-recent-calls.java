/*
 * @lc app=leetcode id=933 lang=java
 *
 * [933] Number of Recent Calls
 */

// @lc code=start
class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        this.queue = new LinkedList<>();
    }
    public int ping(int t) {
        while (!this.queue.isEmpty() && this.queue.peek() < t - 3000) {
            this.queue.poll();
        }

        this.queue.offer(t);
        return this.queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

