class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int count=0,weight=0;
        for(int i=0;i<n*n;i++){
            weight+=w;
            if(weight<=maxWeight){
                count++;
            }
        }
        return count;
    }
}