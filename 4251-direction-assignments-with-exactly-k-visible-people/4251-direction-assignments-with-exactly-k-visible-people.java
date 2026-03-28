class Solution {

    static final int MOD = 1_000_000_007;
    static long[] fact = new long[100001];
    static long[] invf = new long[100001];

    static {
        fact[0] = 1;

        for (int i = 1; i <= 100000; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invf[100000] = modPow(fact[100000], MOD - 2);

        for (int i = 99999; i >= 0; i--) {
            invf[i] = invf[i + 1] * (i + 1) % MOD;
        }
    }

    static long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n)
            return 0;
        return fact[n] * invf[r] % MOD * invf[n - r] % MOD;
    }

    public int countVisiblePeople(int n, int pos, int k) {
        long ans = 2 * nCr(n - 1, k) % MOD;
        return (int) ans;
    }
}