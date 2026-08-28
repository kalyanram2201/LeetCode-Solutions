class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int len = 0, max = 0, count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                count++;
                max = Math.max(count, max);
            } else {
                count++;
            }
        }
        return max;
    }
}