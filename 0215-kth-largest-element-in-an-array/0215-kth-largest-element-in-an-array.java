class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0||nums.length<k){
            return -1;
        }
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
}