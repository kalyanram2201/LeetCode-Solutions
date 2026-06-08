class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        List<Integer>list3=new ArrayList<>();
        for(int num:nums){
            if(num<pivot){
                list1.add(num);
            }
            if(num==pivot){
                list2.add(num);
            }
            if(num>pivot){
                list3.add(num);
            }
        }
        int i=0;
        for(int num:list1)
            nums[i++]=num;
        for(int num:list2)
            nums[i++]=num;
        for(int num:list3)
            nums[i++]=num;
        return nums;
    }
}