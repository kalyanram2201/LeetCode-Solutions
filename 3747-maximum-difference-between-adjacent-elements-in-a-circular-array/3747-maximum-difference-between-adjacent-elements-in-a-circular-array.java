class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE, i;
        for (i = 0; i < nums.length - 1; i++) {
            int val = Math.abs(nums[i] - nums[i + 1]);
            max = Math.max(val, max);
        }
        max = Math.max(Math.abs(nums[nums.length - 1] - nums[0]), max);
        return max;
    }
}