class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, sum = 0;

        int left = 0, min = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                }
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}