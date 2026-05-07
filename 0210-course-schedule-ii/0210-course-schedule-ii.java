import java.util.*;

class Solution {

    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {

            graph.get(p[1]).add(p[0]);

            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];

        int index = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            order[index++] = course;

            for (int neighbor : graph.get(course)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (index == numCourses) {
            return order;
        }

        return new int[0];
    }
}