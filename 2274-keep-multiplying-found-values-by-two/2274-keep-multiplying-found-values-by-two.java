class Solution {
    public int findFinalValue(int[] nums, int original) {
        if (nums.length == 0) {
            return original;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == original) {
                original *= 2;
                i = 0;
            } else {
                i++;
            }

        }
        return original;
    }
}