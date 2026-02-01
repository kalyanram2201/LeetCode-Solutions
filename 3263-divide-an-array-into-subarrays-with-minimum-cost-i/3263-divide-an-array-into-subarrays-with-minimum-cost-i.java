class Solution {
    public int minimumCost(int[] nums) {
        int k=nums[0];
        Arrays.sort(nums,1,nums.length);
        return k+nums[1]+nums[2];
    }
}