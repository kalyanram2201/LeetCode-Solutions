class Solution {
    public long maximumValue(int n, int s, int m) {
        if (n == 1)
            return s;
        long temp = n / 2L;
        return (long) s + (long) m + (temp - 1) * (m - 1);
    }
}