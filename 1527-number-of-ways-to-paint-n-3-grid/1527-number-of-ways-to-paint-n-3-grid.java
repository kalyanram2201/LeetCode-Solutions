class Solution {
    public int numOfWays(int n) {
        int mod = 1_000_000_007;
        long f = 6, s = 6;
        for (int i = 2; i <= n; i++) {
            long newf = (2 * f + 2 * s) % mod;
            long news = (2 * f + 3 * s) % mod;
            f = newf;
            s = news;
        }
        return (int) ((f + s) % mod);
    }
}