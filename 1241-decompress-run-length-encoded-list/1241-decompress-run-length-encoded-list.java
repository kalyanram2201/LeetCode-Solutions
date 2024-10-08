class Solution {
    public int[] decompressRLElist(int[] nums) {
        if(nums==null ||nums.length%2!=0){
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            int fre=nums[i];
            int val=nums[i+1];
            for(int j=0;j<fre;j++){
               result.add(val);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}