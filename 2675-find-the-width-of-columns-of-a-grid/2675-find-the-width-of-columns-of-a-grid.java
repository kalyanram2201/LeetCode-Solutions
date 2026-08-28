class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            int colWidth = 0;
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                int width = String.valueOf(val).length();
                colWidth = Math.max(colWidth, width);
            }
            result[j] = colWidth;
        }
        return result;
    }
}
