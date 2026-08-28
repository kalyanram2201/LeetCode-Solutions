class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean visit[][] = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { grid[0][0], 0, 0 });
        int max = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0], r = curr[1], c = curr[2];
            max = Math.max(max, height);
            if (r == n - 1 && c == n - 1)
                return max;
            if (visit[r][c])
                continue;
            visit[r][c] = true;
            for (int dir[] : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    pq.offer(new int[] { grid[nr][nc], nr, nc });
                }
            }
        }
        return -1;
    }
}