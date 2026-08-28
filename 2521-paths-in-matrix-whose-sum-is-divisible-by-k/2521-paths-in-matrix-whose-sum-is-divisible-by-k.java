class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][] result = new int[n][k];
        int[][] temp = new int[n][k];

        int val = grid[0][0] % k;
        result[0][val] = 1;
        for (int j = 1; j < n; j++) {
            int v = grid[0][j] % k;
            for (int r = 0; r < k; r++) {
                if (result[j - 1][r] != 0) {
                    int nr = (r + v) % k;
                    result[j][nr] = (result[j][nr] + result[j - 1][r]) % MOD;
                }
            }
        }
        for (int i = 1; i < m; i++) {

            Arrays.fill(temp[0], 0);
            int v0 = grid[i][0] % k;

            for (int r = 0; r < k; r++) {
                if (result[0][r] != 0) {
                    int nr = (r + v0) % k;
                    temp[0][nr] = (temp[0][nr] + result[0][r]) % MOD;
                }
            }

            for (int j = 1; j < n; j++) {
                Arrays.fill(temp[j], 0);
                int v = grid[i][j] % k;

                for (int r = 0; r < k; r++) {
                    if (temp[j - 1][r] != 0) {
                        int nr = (r + v) % k;
                        temp[j][nr] = (temp[j][nr] + temp[j - 1][r]) % MOD;
                    }

                    if (result[j][r] != 0) {
                        int nr = (r + v) % k;
                        temp[j][nr] = (temp[j][nr] + result[j][r]) % MOD;
                    }
                }
            }

            int[][] t = result;
            result = temp;
            temp = t;
        }

        return result[n - 1][0];
    }
}
