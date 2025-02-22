class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int[] arr=new int[m+n];
        System.arraycopy(nums1,0,arr,0,m);
        System.arraycopy(nums2,0,arr,m,n);
        Arrays.sort(arr);
        int size=arr.length;
        if(size%2==0){
            return (arr[size/2]+arr[(size/2)-1])/2.0;
        }
        return arr[size/2];
    }
}