class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.parallelSort(nums);
        if(nums.length<0){
            return 0;
        }
        return (nums[nums.length-1]*nums[nums.length-2])-(nums[0]*nums[1]);
    }
}