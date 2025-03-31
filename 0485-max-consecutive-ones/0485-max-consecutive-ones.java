class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0,n=nums.length,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==0){ 
                max=Math.max(count,max);
                count=0;
            }else{
                count++;
                max=Math.max(count,max);
            }
        }
        return max;
    }
}