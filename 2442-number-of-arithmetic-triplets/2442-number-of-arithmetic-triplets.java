class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count=0,n=nums.length;
        if(n<3)return 0;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(nums[j]-nums[i]!=diff)continue;
                for(int k=j+1;k<n;k++){
                    if(nums[k]-nums[j]==diff)count++;
                }
            }
        }
        return count;
    }
}