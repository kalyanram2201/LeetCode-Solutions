class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefix[i] = nums[i] + prefix[i + 1];
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int remaining = n - i - 1;
            if (nums[i] > prefix[i + 1] / remaining) {
                count++;
            }
        }
        return count;
    }
}
