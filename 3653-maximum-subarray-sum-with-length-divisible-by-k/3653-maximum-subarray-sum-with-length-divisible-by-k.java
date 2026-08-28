class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n];
        long min = Long.MAX_VALUE / 2;
        for (int i = 0; i < k; i++)
            pre[i] = min;
        pre[k - 1] = 0;
        long val = 0, ans = -min;
        for (int i = 0; i < n; i++) {
            val += nums[i];
            int p = i % k;
            ans = Math.max(ans, val - pre[p]);
            pre[p] = Math.min(val, pre[p]);
        }
        return ans;
    }
}