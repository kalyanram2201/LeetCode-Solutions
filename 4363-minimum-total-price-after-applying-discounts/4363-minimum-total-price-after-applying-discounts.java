class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int n = prices.length;
        int m = discounts.length;

        double sum = 0;

        int i = n - 1;

        for (int j = m - 1; j >= 0 && i >= 0; j--) {
            sum += prices[i] * (100 - discounts[j]) / 100.0;
            i--;
        }

        while (i >= 0) {
            sum += prices[i];
            i--;
        }

        return sum;
    }
}