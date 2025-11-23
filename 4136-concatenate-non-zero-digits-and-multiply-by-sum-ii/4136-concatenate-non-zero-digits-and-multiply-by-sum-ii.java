class Solution {
    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;

        int[] pCount = new int[n];
        long[] pSum = new long[n];
        long[] pVal = new long[n];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            if (i > 0) {
                pCount[i] = pCount[i - 1];
                pSum[i] = pSum[i - 1];
                pVal[i] = pVal[i - 1];
            }

            if (d != 0) {
                pCount[i]++;
                pSum[i] += d;
                pVal[i] = (pVal[i] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];

            int count = pCount[r] - (l > 0 ? pCount[l - 1] : 0);
            long sum = pSum[r] - (l > 0 ? pSum[l - 1] : 0);

            long x = pVal[r];
            if (l > 0) {
                long removed = (pVal[l - 1] * pow10[count]) % MOD;
                x = (x - removed + MOD) % MOD;
            }

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}
