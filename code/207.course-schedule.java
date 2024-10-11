/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            numCourses--;
            for (int nextCourse : map.getOrDefault(course, new ArrayList<>())) {
                if (--inDegree[nextCourse] == 0){
                    queue.addLast(nextCourse);
                }
            }
        }
        return numCourses == 0;
    }
}
// @lc code=end

