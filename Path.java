import java.util.*;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // effort, x, y

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int e = curr[0], x = curr[1], y = curr[2];

            if (x == m - 1 && y == n - 1) return e;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                int newEffort = Math.max(e, Math.abs(heights[nx][ny] - heights[x][y]));
                if (newEffort < effort[nx][ny]) {
                    effort[nx][ny] = newEffort;
                    pq.offer(new int[]{newEffort, nx, ny});
                }
            }
        }
        return 0;
    }

    // Quick test
    public static void main(String[] args) {
        PathWithMinimumEffort sol = new PathWithMinimumEffort();
        int[][] heights = {
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };
        System.out.println(sol.minimumEffortPath(heights)); // Output: 2
    }
}
