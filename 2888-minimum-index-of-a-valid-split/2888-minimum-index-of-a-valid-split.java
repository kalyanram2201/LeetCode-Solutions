class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int val=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            int temp=max;
            max=Math.max(max,map.get(num));
            if(temp!=max){
                val=num;
            }
        }
        int left=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==val){
                left++;
            }
            int leftsub=left;
            int rightsub=max-left;

            if(leftsub>(i+1)/2 && rightsub>(n-i-1)/2)
                return i;
        }
        return -1;

    }
}