class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visit[i][j]) {
                    int sum = dfs(grid, visit, i, j);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int dfs(int[][] grid, boolean[][] visit, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || visit[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visit[i][j] = true;
        int sum = grid[i][j];
        sum += dfs(grid, visit, i + 1, j);
        sum += dfs(grid, visit, i, j + 1);
        sum += dfs(grid, visit, i, j - 1);
        sum += dfs(grid, visit, i - 1, j);
        return sum;
    }
}