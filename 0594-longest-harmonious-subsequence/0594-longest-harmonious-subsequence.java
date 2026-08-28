class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, maxLength = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1)
                maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}