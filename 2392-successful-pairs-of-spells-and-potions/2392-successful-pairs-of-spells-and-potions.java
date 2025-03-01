class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        if(spells.length==0){
            return spells;
        }
        if(potions.length==0){
            return new int[spells.length];
        }
        int result[]=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int low=0,high=potions.length-1;
            int count=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                long product=(long)spells[i]*potions[mid];
                if(product>=success){
                    count=potions.length-mid;
                    
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            result[i]=count;
        }
        return result;
    }
}