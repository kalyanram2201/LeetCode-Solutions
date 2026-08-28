class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int temp = 0;

        for (int i = 0; i <= temp; i++) {
            temp = Math.max(temp, i + nums[i]);
            if (temp >= n - 1)
                return true;
        }

        return false;
    }
}
