class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for(int num:nums)max=Math.max(max,num);
        int left=0;
        long freq=0,result=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==max)freq++;
            while(freq>=k){
                if(nums[left]==max)freq--;
                left++;
            }
            result+=left;
        }
        return result;
    }
}