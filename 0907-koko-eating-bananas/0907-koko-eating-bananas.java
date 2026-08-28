class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
        for(int pile:piles){
            right=Math.max(pile,right);
        }

        while(left<right){
            int mid=left+(right-left)/2;
            int hr=0;
            for(int pile:piles){
                hr+=(pile+mid-1)/mid;
            }
            if(hr<=h){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}