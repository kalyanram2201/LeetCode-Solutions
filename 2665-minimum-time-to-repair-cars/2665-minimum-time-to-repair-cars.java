class Solution {
    public long repairCars(int[] ranks, int cars) {
        if(ranks.length==0){
            return 0;
        }
        int minR=ranks[0],maxR=ranks[0];
        for(int num:ranks){
            minR=Math.min(minR,num);
            maxR=Math.max(maxR,num);
        }

        int[] result=new int[maxR+1];
        for(int rank:ranks){
            minR=Math.min(minR,rank);
            result[rank]++;
        }
        long low=1,high=1L*minR*cars*cars;
        while(low<high){
            long mid=(low+high)/2;
            long carR=0;
            for(int i=1;i<=maxR;i++){
                carR+=result[i]*(long)Math.sqrt(mid/(long)i);
            }
            if(carR>=cars){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}