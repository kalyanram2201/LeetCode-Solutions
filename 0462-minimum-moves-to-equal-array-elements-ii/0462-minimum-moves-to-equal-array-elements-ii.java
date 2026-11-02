class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        long res = 0;
        for (int num : nums) {
            res += Math.abs(num - mid);
        }
        return (int) res;
    }
}