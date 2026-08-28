class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int cur = 0, profit = 0;
        boolean accept = false;

        for (int i = 0; i < n - 1; i++) {
            if (!accept && prices[i] < prices[i + 1]) {
                cur = prices[i];
                accept = true;
            } else if (accept && prices[i] > prices[i + 1]) {
                profit += prices[i] - cur;
                accept = false;
            }
        }

        if (accept)
            profit += prices[n - 1] - cur;
        return profit;
    }
}