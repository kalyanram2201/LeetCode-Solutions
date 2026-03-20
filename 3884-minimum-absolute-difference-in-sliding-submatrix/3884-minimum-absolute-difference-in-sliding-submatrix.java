class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> list = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int p = j; p < j + k; p++) {
                        list.add(grid[x][p]);
                    }
                }
                Collections.sort(list);
                int min = Integer.MAX_VALUE;
                int prev = list.get(0);
                for (int x = 1; x < list.size(); x++) {
                    if (list.get(x) != prev) {
                        min = Math.min(min, list.get(x) - prev);
                    }
                    prev = list.get(x);
                }
                result[i][j] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }
        return result;
    }
}