class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums1)map.put(num,map.getOrDefault(num,0)+1);
        for(int num:nums2)map.put(num,map.getOrDefault(num,0)+1);
        for(int val:map.values()){
            if(val%2!=0)return -1;
        }
        Map<Integer,Integer> feq1=new HashMap<>();
        Map<Integer,Integer> feq2=new HashMap<>();
        for(int num:nums1)feq1.put(num,feq1.getOrDefault(num,0)+1);
        for(int num:nums2)feq2.put(num,feq2.getOrDefault(num,0)+1);
        int swaps=0;
        for(int key:map.keySet()){
            int f1=feq1.getOrDefault(key,0);
            int f2=feq2.getOrDefault(key,0);
            swaps+=Math.abs(f1-f2)/2;
        }
        return swaps/2;
        
    }
}