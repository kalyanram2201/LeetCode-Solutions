class Solution {
    static final int MOD = 1000000007;

    public int countEffective(int[] nums) {
        int n = nums.length;

        int TOT = 0;
        for (int x : nums) TOT |= x;
        if (TOT == 0) return 0;

        int[] bitPos = new int[20];
        int k = 0;
        for (int b = 0; b < 20; b++) {
            if ((TOT & (1 << b)) != 0) bitPos[k++] = b;
        }

        int M = 1 << k;
        int[] cnt = new int[M];
        for (int x : nums) {
            int mask = 0;
            for (int j = 0; j < k; j++) {
                if ((x & (1 << bitPos[j])) != 0) mask |= (1 << j);
            }
            cnt[mask]++;
        }

        long[] subsetSum = new long[M];
        for (int m = 0; m < M; m++) subsetSum[m] = cnt[m];
        for (int i = 0; i < k; i++) {
            for (int mask = 0; mask < M; mask++) {
                if ((mask & (1 << i)) != 0) subsetSum[mask] += subsetSum[mask ^ (1 << i)];
            }
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) pow2[i] = (pow2[i - 1] * 2) % MOD;

        long ans = 0;
        int full = M - 1;

        for (int B = 1; B < M; B++) {
            int comp = full ^ B;
            long nonIntersect = subsetSum[comp];
            int unionSize = n - (int) nonIntersect;
            long add = pow2[n - unionSize];
            if (Integer.bitCount(B) % 2 == 1) ans += add;
            else ans -= add;
            ans %= MOD;
        }

        if (ans < 0) ans += MOD;
        return (int) ans;
    }
}
