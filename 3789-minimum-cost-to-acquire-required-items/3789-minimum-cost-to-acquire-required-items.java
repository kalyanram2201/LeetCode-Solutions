class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, cb = costBoth, n1 = need1, n2 = need2;
        long pairs = Math.min(n1, n2);
        long cpairs = pairs * Math.min(cb, c1 + c2);
        long rem1 = n1 - pairs, rem2 = n2 - pairs;
        long crem = rem1 * Math.min(c1, cb) + rem2 * Math.min(c2, cb);
        return cpairs + crem;
    }
}