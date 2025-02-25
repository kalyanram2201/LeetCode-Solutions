class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        if(matrix.length==0){
            return new ArrayList<>();
        }
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            int min=Integer.MAX_VALUE;
            int k=0;
            for(int j=0;j<n;j++){
               min=Math.min(matrix[i][j],min);
               if(min==matrix[i][j]){
                k=j;
               } 
            }
            int max=0;
            for(int j=0;j<m;j++){
                max=Math.max(max,matrix[j][k]);
            }
            if(min==max)
                list.add(max);
        }
        return list;
    }
}