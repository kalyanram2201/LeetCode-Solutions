class Solution {
    int helper(int[] nums, int k) {
        if (k < 0)
            return 0;
        int count = 0, l = 0, sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += (nums[r] % 2);
            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
}