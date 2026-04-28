class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);
        int length=list.size();
        int val=list.get(length/2),result=0;
        for(int i=0;i<length;i++){
            if(val%x!=list.get(i)%x){
                return -1;
            }
            result+=Math.abs(val-list.get(i))/x;

        }
        return result;
    }
}