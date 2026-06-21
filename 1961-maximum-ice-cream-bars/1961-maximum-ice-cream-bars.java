class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (cost > coins) {
                break;
            }
            res++;
            coins -= cost;
        }
        return res;
    }
}