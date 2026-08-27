class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] sum = new int[m + 1][n + 1];
        int[][] xCount = new int[m + 1][n + 1];

        int count = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char ch = grid[i - 1][j - 1];

                int val = 0;
                int x = 0;

                if (ch == 'X') {
                    val = 1;
                    x = 1;
                } else if (ch == 'Y') {
                    val = -1;
                }

                sum[i][j] = val
                        + sum[i - 1][j]
                        + sum[i][j - 1]
                        - sum[i - 1][j - 1];

                xCount[i][j] = x
                        + xCount[i - 1][j]
                        + xCount[i][j - 1]
                        - xCount[i - 1][j - 1];

                if (sum[i][j] == 0 && xCount[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}