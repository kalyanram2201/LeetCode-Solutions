class Solution {
    public int countPartitions(int[] nums) {
        int left = 0;
        int right = 0;
        for (int x : nums) {
            right += x;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            left += nums[i];
            right -= nums[i];
            if ((left - right) % 2 == 0) {
                ++ans;
            }
        }
        return ans;
    }
}