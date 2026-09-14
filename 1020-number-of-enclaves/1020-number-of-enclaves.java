class Solution {
    int row[] = { -1, 0, 1, 0 };
    int col[] = { 0, 1, 0, -1 };

    boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;
        return true;
    }

    void bfs(int[][] grid, Queue<int[]> q, boolean[][] visit) {
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];

                if (isValid(nr, nc, n, m) && grid[nr][nc] == 1 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1) {
                    visit[i][j] = true;
                    q.add(new int[] { i, j });
                }
            }
        }
        bfs(grid, q, visit);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visit[i][j])
                    count++;
            }
        }
        return count;
    }
}