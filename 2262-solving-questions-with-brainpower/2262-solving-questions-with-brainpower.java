class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // DP array to store max points at each index

        for (int i = n - 1; i >= 0; i--) {
            long points = questions[i][0];
            int brainpower = questions[i][1];
            int next = i + brainpower + 1;

            // Option 1: Solve this question and add the best possible next value
            long take = points + (next < n ? dp[next] : 0);
            // Option 2: Skip this question and take the next value
            long skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0]; // Maximum points achievable starting from index 0
    }
}
