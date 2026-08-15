class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int res = 0;
        boolean zero = false;
        for (int num : nums) {
            zero |= num > 0;
            res ^= num;
        }
        if (!zero)
            return 0;
        return res == 0 ? n - 1 : n;
    }
}