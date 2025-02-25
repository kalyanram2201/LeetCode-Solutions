class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        if(matrix.length==0)
        {
            return matrix;
        }
        int[][] copy=new int[matrix.length][];
        for(int i=0;i<matrix.length;i++)
        {
            copy[i]=matrix[i].clone();
        }

        for(int i=0;i<copy.length;i++)
        {
            for(int j=0;j<copy[0].length;j++)
            {
                if(copy[i][j]==-1)
                {
                    int max=0;
                    int k=0;
                    while(k<copy.length){
                        max=Math.max(max,copy[k][j]);
                        k++;
                    }
                    copy[i][j]=max;
                }
            }
        }
        return copy;
    }
}