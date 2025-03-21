class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max1=0,max2=0;
        for(int num:nums){
            if(max1<num){
                max2=max1;
                max1=num;
            }else if(num>max2){
                max2=num;
            }
        }
        return (max1-1)*(max2-1);
    }
}