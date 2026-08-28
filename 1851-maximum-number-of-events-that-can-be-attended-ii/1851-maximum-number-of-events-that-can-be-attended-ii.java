class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        int dp[][] = new int[n + 1][k + 1];

        int next[] = new int[n];
        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            next[i] = left;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], events[i][2] + dp[next[i]][j - 1]);
            }
        }
        return dp[0][k];
    }
}