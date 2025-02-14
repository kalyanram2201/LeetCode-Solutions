class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int []arr=new int[2];
        arr[0]=firstIndex(nums,target);
        arr[1]=secondIndex(nums,target);
        return arr;
    }
    private int firstIndex(int []nums,int target){
        int low=0,high=nums.length-1,index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
            if(nums[mid]==target){
                index=mid;
            }
        }
        return  index;
    }
    private int secondIndex(int []nums,int target){
        int low=0,high=nums.length-1,index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }else{
                high=mid-1;
            }
            if(nums[mid]==target){
                index=mid;
            }
        }
        return index;
    }
}