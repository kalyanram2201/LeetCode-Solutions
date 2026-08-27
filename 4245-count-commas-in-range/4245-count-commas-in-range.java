class Solution {
    public int countCommas(int n) {
        if (n < 1000)
            return 0;

        int ans = 0, start = 1, digit = 1;
        while (start <= n) {
            int end = Math.min(n, start * 10 - 1);
            int count = end - start + 1;
            int commas = (digit - 1) / 3;
            ans += count * commas;
            start *= 10;
            digit++;
        }
        return ans;
    }
}