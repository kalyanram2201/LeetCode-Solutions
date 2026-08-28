class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            int val = matrix[row][col];
            
            if (val == target) {
                return true;
            } else if (val > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
