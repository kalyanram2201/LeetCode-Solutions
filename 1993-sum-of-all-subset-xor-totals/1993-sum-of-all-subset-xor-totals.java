class Solution {
    public int subsetXORSum(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum |=num;
        }
        return sum* (int)Math.pow(2,nums.length-1);
    }
}