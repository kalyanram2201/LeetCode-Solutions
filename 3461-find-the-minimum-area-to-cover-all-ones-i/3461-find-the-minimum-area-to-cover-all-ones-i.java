class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mini = n, minj = m, maxi = -1, maxj = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    mini = Math.min(mini, i);
                    maxi = Math.max(maxi, i);
                    minj = Math.min(minj, j);
                    maxj = Math.max(maxj, j);
                }
            }
        }
        
        if (maxi == -1) return 0;
        return (maxi - mini + 1) * (maxj - minj + 1);
    }
}
