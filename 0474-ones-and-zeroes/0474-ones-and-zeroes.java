class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0, ones = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0')
                    zero++;
                else
                    ones++;
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}