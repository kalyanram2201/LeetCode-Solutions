class Solution {

    int helper(String s, String t, int i, int j, int m, int n, int[][] dp) {
        if (j == n)
            return 1;
        if (i == m)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            int skip = helper(s, t, i + 1, j, m, n, dp);
            int take = helper(s, t, i + 1, j + 1, m, n, dp);

            return dp[i][j] = skip + take;
        } else {
            return dp[i][j] = helper(s, t, i + 1, j, m, n, dp);
        }
    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[m][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s, t, 0, 0, m, n, dp);
    }
}