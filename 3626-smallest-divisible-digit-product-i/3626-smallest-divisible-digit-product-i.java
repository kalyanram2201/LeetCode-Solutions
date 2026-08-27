class Solution {
    public int smallestNumber(int n, int t) {
        int res = -1;
        for (int i = n; i <= n + 10; i++) {
            int prod = 1;
            int val = i;
            while (val > 0) {
                prod *= val % 10;
                val = val / 10;
            }
            if (prod % t == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}