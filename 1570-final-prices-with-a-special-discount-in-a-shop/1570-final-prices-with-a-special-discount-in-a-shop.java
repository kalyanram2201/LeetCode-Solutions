class Solution {
    public int[] finalPrices(int[] prices) {
        int result[]=new int[prices.length],n=prices.length;
        for(int i=0;i<n;i++){
            int val=prices[i];
            for(int j=i+1;j<n;j++){
                if(val>=prices[j]){
                    val-=prices[j];
                    break;
                }
            }
            result[i]=val;
        }
        return result;
    }
}