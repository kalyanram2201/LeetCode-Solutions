class Solution {

    Boolean[][][] dp;

    boolean isValid(int i, int j, int balance,
            int m, int n, char[][] grid) {

        if (i >= m || j >= n) {
            return false;
        }

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        if (i == m - 1 && j == n - 1) {
            return dp[i][j][balance] = (balance == 0);
        }

        boolean down = isValid(
                i + 1, j, balance, m, n, grid);

        boolean right = isValid(
                i, j + 1, balance, m, n, grid);

        return dp[i][j][balance] = down || right;
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        dp = new Boolean[m][n][m + n + 1];

        return isValid(0, 0, 0, m, n, grid);
    }
}