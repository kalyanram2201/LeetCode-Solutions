class Solution {
    static int mod = 1_000_000_007;

    public int countArrays(int[] digitSum) {
        int n = digitSum.length;
        int[] sum = new int[5001];
        for (int i = 0; i < 5001; i++) {
            int val = i, s = 0;
            while (val > 0) {
                s += val % 10;
                val /= 10;
            }
            sum[i] = s;
        }

        long[] dp = new long[5001];

        for (int i = 0; i < 5001; i++) {
            if (sum[i] == digitSum[0]) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            long[] ndp = new long[5001];
            long pre = 0;

            for (int j = 0; j < 5001; j++) {
                pre = (pre + dp[j]) % mod;
                if (sum[j] == digitSum[i]) {
                    ndp[j] = pre;
                }
            }
            dp = ndp;
        }
        long ans = 0;
        for (long val : dp) {
            ans = (ans + val) % mod;
        }
        return (int) ans;
    }
}