/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.addLast(0);
        dfs(graph, 0, graph.length - 1);
        return res;
    }

    public void dfs(int[][] graph, int m, int n) {
        if (m == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int v : graph[m]) {
            path.addLast(v);
            dfs(graph, v, n);
            path.removeLast();
        }
    }
}
// @lc code=end

