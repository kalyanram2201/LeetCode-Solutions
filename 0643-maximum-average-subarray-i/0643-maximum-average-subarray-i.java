class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        
        int n = nums.length;
        double maxAvg;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        maxAvg = sum / (double) k;

        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            maxAvg = Math.max(maxAvg, sum / (double) k);
        }

        return maxAvg;
    }
}
