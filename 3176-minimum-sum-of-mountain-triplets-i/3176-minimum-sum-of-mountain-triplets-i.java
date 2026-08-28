class Solution {
    public int minimumSum(int[] nums) {
        if(nums.length<3)return -1;
        int min=Integer.MAX_VALUE,n=nums.length;
        boolean exits=false;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(nums[i]>=nums[j])continue;
                for(int k=j+1;k<n;k++){
                    if(nums[k]>=nums[j])continue;
                    min=Math.min(min,nums[i]+nums[j]+nums[k]);
                    exits=true;
                }
            }
        }
        return exits?min:-1;
    }
}