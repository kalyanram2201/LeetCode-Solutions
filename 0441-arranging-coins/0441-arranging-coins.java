class Solution {
    public int arrangeCoins(int n) {
        int count = 0, i = 1;
        while (n > 0) {
            n = n - i++;
            if (n >= 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}