class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int count = 0, max = 0, temp = k, left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else if (temp > 0) {
                count++;
                temp--;
            } else {
                while (nums[left] == 1) {
                    count--;
                    left++;
                }
                left++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
