class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<height.length-1;i++){
            if(height[i]>threshold){
                result.add(i+1);
            }
        }
        return result;
    }
}