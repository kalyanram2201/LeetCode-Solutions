class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        
        for (int arr[] : accounts) {
            int sum = 0;
            for (int val : arr) {
                sum += val;
            }
            wealth = Math.max(wealth, sum);
        }
        return wealth;
    }
}