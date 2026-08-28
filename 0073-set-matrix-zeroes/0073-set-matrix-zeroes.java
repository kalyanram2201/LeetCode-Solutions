import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];

        
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    
                    for (int x = 0; x < m; x++) {
                        result[x][j] = 0;
                    }
                    
                    for (int y = 0; y < n; y++) {
                        result[i][y] = 0;
                    }
                } else if (result[i][j] != 0) { 
                    result[i][j] = matrix[i][j];
                }
            }
        }

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
