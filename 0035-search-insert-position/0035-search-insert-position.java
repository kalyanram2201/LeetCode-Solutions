class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int index=0;
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i]==target){
                index=i;
                break;
            }
            if(nums[i]>target){
                index=i;
                break;
            }
        }
        if(i==nums.length && index==0){
            index=nums.length;
        }
        return index;
    }
}