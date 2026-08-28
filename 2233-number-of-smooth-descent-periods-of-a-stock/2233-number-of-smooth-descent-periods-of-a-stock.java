class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        long temp = 0;
        count += prices.length;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                temp++;
                count += temp;
            } else {
                temp = 0;
            }
        }
        return count;
    }
}