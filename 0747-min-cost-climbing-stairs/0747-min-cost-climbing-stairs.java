class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==2){
            return Math.min(cost[0],cost[1]);
        }

        int fst=cost[0];
        int scd=cost[1];
        for(int i=2;i<n;i++){
            int current=cost[i]+Math.min(fst,scd);
            fst=scd;
            scd=current;
        }
        return Math.min(fst,scd);
    }
}