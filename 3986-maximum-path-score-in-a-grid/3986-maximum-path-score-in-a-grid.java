class Solution {
    int[][][] memo;
    int m, n;

    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n][k + 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);

        int result = dfs(0, 0, k, grid);
        return result < 0 ? -1 : result;
    }

    private int dfs(int i, int j, int remK, int[][] grid) {
        if (i >= m || j >= n || remK < 0)
            return -1;

        if (i == m - 1 && j == n - 1) {
            int val = grid[i][j];
            int score = (val == 2 ? 2 : val);
            int cost = (val == 0 ? 0 : 1);
            if (remK - cost < 0)
                return -1;
            return score;
        }

        if (memo[i][j][remK] != Integer.MIN_VALUE)
            return memo[i][j][remK];

        int val = grid[i][j];
        int score = (val == 2 ? 2 : val);
        int cost = (val == 0 ? 0 : 1);

        int right = dfs(i, j + 1, remK - cost, grid);
        int down = dfs(i + 1, j, remK - cost, grid);

        int best = Math.max(right, down);

        if (best == -1)
            memo[i][j][remK] = -1;
        else
            memo[i][j][remK] = score + best;

        return memo[i][j][remK];
    }
}