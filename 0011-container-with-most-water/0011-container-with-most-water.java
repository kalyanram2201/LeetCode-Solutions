class Solution {
    public int maxArea(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        int max=Integer.MIN_VALUE;
        
        while(left<=right){
            if(nums[left]<nums[right]){
                max=Math.max(max,Math.abs(right-left)*nums[left]);
                left++;
            }else{
                max=Math.max(max,Math.abs(right-left)*nums[right]);
                right--;
            }
        }
        return max;
    }
}