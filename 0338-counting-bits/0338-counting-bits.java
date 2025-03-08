class Solution {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[1];
        }
        int result[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = result[i/2]+(i&1);
        }
        return result;
    }
}