class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int count=0;
        for(int num:nums){
            count+=Math.abs(num-max);
        }
        return count;
    }
}