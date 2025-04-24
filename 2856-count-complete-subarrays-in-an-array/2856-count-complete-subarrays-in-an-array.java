class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
        Set<Integer> distinct=new HashSet<>();
        for(int num:nums){
            distinct.add(num);
        }

        int unique=distinct.size();
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            Set<Integer> temp=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                temp.add(nums[j]);
            
                if(temp.size()==unique)result++;
            }
        }
        return result;
    }
}