class Solution {
    public int pivotInteger(int n) {
        int total = (n * (n + 1)) / 2;
        for (int i = 1; i <= n; i++) {
            int val = (i * (i + 1)) / 2;
            if (val == (total - val + i))
                return i;
        }
        return -1;
    }
}