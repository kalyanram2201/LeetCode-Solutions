class Solution {
    public int totalMoney(int n) {
        int total = 0, start = 1;
        while (n > 0) {
            int cur = start;
            for (int i = 0; i < 7 && n > 0; i++) {
                total += cur;
                cur++;
                n--;
            }
            start++;
        }
        return total;
    }
}