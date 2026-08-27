class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length, val1 = -1, val2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;
            if (nums[i] == 1) {
                val1 = i;
                if (val2 != -1) {
                    min = Math.min(min, Math.abs(val2 - i));
                }
            } else {
                val2 = i;
                if (val1 != -1)
                    min = Math.min(min, Math.abs(val1 - i));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}