class Solution {
    public int scoreDifference(int[] nums) {
        int n = nums.length;
        int first = 0, second = 0;
        boolean active = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                active = !active;
            }
            if (i % 6 == 5) {
                active = !active;
            }
            if (active) {
                first += nums[i];
            } else {
                second += nums[i];
            }
        }
        return first - second;

    }
}