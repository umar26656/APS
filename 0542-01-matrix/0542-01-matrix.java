import java.util.*;

class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited =
                new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {

                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            for (int[] d : dirs) {

                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr >= 0 && nc >= 0
                        && nr < rows && nc < cols
                        && !visited[nr][nc]) {

                    mat[nr][nc] =
                            mat[curr[0]][curr[1]] + 1;

                    visited[nr][nc] = true;

                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}