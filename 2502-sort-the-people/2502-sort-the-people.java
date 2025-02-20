class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        if(names.length==0 || heights.length==0){
            return names;
        }
        Integer index[]=new Integer[heights.length];
        for(int i=0;i<names.length;i++){
            index[i]=i;
        }
        Arrays.sort(index,(a,b)->heights[b]-heights[a]);
        String result[]=new String[names.length];
        for(int i=0;i<names.length;i++){
            result[i]=names[index[i]];
        }
        return result;
    }
}