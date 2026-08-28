class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int val=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            int temp=max;
            max=Math.max(max,map.get(num));
            if(max!=temp)val=num;
        }

        if(max>=nums.length/2)return val;
        return -1;
 }
}