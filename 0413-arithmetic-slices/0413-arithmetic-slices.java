class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0, temp = 0;
        
        if (nums.length < 3)
            return 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                temp++;
                count += temp;
            } else {
                temp = 0;
            }
        }
        return count;
    }
}