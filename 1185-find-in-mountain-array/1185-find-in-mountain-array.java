/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left=0,right=mountainArr.length()-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(mountainArr.get(left)==target){
            return left;
        }
        int i=bisearch(target,0,left-1,mountainArr);
        if(i!=-1){
            return i;
        }
        int j=bjsearch(target,left+1,mountainArr.length()-1,mountainArr);
        return j;
    }

    int bisearch(int target,int left,int right,MountainArray arr){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr.get(mid)==target){
                return mid;
            }else if(arr.get(mid)>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
    int bjsearch(int target,int left,int right,MountainArray arr){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr.get(mid)==target){
                return mid;
            }else if(arr.get(mid)<target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}