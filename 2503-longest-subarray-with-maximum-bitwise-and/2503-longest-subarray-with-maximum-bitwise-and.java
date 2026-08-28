class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int longest = 0;
        int count = 0;

        for (int num : nums) {
            if (num == max) {
                count++;
                longest = Math.max(longest, count);
            } else {
                count = 0;
            }
        }

        return longest;
    }
}
