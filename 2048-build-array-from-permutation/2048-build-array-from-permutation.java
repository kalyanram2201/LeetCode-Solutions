class Solution {
    public int[] buildArray(int[] nums) {
        int result[]=new int[nums.length],n=nums.length;
        for(int i=0;i<n;i++){
            result[i]=nums[nums[i]];
        }
        return result;
    }
}