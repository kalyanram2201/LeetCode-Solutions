class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count=k;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1 && count<k){
                return false;
            }else if(nums[i]==1 && count>=k){
                count=0;
            }else{
                count++;
            }
        }
        return true;
    }
}