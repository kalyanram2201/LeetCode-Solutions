class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long originalProfit = 0;

        for (int i = 0; i < n; i++)
            originalProfit += (long) strategy[i] * prices[i];

        long[] prefixSP = new long[n + 1];
        long[] prefixP = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSP[i + 1] = prefixSP[i] + (long) strategy[i] * prices[i];
            prefixP[i + 1] = prefixP[i] + prices[i];
        }

        long best = originalProfit;
        int half = k / 2;
        for (int l = 0; l + k <= n; l++) {
            int mid = l + half, r = l + k;
            long delta1 = -(prefixSP[mid] - prefixSP[l]);
            long delta2 = (prefixP[r] - prefixP[mid]) - (prefixSP[r] - prefixSP[mid]);
            best = Math.max(best, originalProfit + delta1 + delta2);
        }
        return best;
    }
}