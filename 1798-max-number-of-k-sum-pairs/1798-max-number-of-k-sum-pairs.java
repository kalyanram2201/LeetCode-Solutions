class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.parallelSort(nums);
        if(nums.length==0){
            return 0;
        }
        int left=0,right=nums.length-1,count=0;

        while(left<right){
            int val=nums[left]+nums[right];
            if(val==k){
                left++;
                right--;
                count++;
            }else if(val<k){
                left++;
            }else{
                right--;
            }
           
        }
        return count;

    }
}