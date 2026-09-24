class Solution {
    public int smallestIndex(int[] nums) {
        int min = 101;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 10 && i == nums[i])
                min = Math.min(i, min);
            else {
                int val = nums[i];
                int sum = 0;
                while (val > 0) {
                    sum += val % 10;
                    val /= 10;
                }
                if (sum == i)
                    min = Math.min(i, min);
            }
        }
        return min == 101 ? -1 : min;
    }
}