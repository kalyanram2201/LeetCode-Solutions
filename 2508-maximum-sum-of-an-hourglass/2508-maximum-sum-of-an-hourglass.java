class Solution {
    public int maxSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(row<3||col<3){
            return Integer.MIN_VALUE;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=row-3;i++){
            for(int j=0;j<=col-3;j++){
                int sum=grid[i][j]+grid[i][j+1]+grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
    
}