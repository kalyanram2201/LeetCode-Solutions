class Solution {
    public long countCommas(long n) {
        if (n < 1000)
            return 0;

        long ans = 0, start = 1, digit = 1;
        while (start <= n) {
            long end = Math.min(n, start * 10 - 1);
            long count = end - start + 1;
            long commas = (digit - 1) / 3;
            ans += count * commas;
            start *= 10;
            digit++;
        }
        return ans;
    }
}