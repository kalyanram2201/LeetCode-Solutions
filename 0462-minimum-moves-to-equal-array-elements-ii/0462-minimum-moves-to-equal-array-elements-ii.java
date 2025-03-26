class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int val=nums[len/2];
        int count=0;
        for(int num:nums){
            count+=Math.abs(val-num);
        }
        return count;
    }
}