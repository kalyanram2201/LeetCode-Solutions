class Solution {
    int[] row = { -1, 0, 1, 0 };
    int[] col = { 0, 1, 0, -1 };

    boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;
        return true;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time = 0, total = 0, count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0)
                    total++;
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int k = q.size();
            count += k;

            for (int i = 0; i < k; i++) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for (int j = 0; j < 4; j++) {
                    int nr = r + row[j];
                    int nc = c + col[j];

                    if (isValid(nr, nc, n, m) && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
            if (!q.isEmpty())
                time++;
        }

        return total == count ? time : -1;
    }
}
