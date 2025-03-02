class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            int low=0,high=col-1;
            if(target>matrix[i][high]){
                continue;
            }
            while(low<=high){
                int mid=low+(high-low)/2;
                if(matrix[i][mid]==target){
                    return true;
                }else if(matrix[i][mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        return false;
    }
}