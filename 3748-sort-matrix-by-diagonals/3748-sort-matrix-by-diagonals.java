class Solution {
    public int[][] sortMatrix(int[][] grid) {
        if(grid.length==0){
            return grid;
        }
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row-1;i++){
            for(int j=0;j<col-1;j++){
                if(i==j){
                    int k=i+1;
                    int m=i;
                    int max=grid[i][j];
                    while(k<row){
                        if(max<grid[k][k]){
                            max=grid[k][k];
                            m=k;
                        }
                        k++;
                    }
                    grid[m][m]=grid[i][j];
                    grid[i][j]=max;
                }
                    
                if(i>j){
                    int k=i+1;
                    int l=j+1;
                    int m=i;
                    int n=j;
                    int max=grid[i][j];
                    while(k<row && l<col-1){
                        if(max<grid[k][l]){
                            max=grid[k][l];
                            m=k;
                            n=l;
                        }
                        k++;
                        l++;
                    }
                    grid[m][n]=grid[i][j];
                    grid[i][j]=max;
                }
                else if(i<j){
                    int k=i+1;
                    int l=j+1;
                    int m=i;
                    int n=j;
                    int min=grid[i][j];
                    while(k<row-1 && l<col){
                        if(min>grid[k][l]){
                            min=grid[k][l];
                            m=k;
                            n=l;
                        }
                        k++;
                        l++;
                    }
                    grid[m][n]=grid[i][j];
                    grid[i][j]=min;
                }       
            }
          
        }
        return grid;
    }
}