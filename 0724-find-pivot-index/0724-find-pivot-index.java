class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int sum = Arrays.stream(nums).sum();
        for(int i=0;i<nums.length;i++){
            int right=sum-left-nums[i];
            if(left==right){
                return i;
            }
            left+=nums[i];
        }
        return -1;
    }
}