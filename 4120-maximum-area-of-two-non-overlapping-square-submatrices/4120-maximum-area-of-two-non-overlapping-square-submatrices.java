class Solution {
    public int maxArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = mat[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
            }
        }

        int lo = 1, hi = Math.min(m, n);
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canPlace(mid, m, n, sum)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans * ans;
    }

    private boolean canPlace(int k, int m, int n, int[][] sum) {
        List<int[]> pos = new ArrayList<>();
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;

        for (int r = 0; r <= m - k; r++) {
            for (int c = 0; c <= n - k; c++) {
                int area = getArea(sum, r, c, r + k - 1, c + k - 1);
                if (area == k * k) {
                    pos.add(new int[] { r, c });
                    minRow = Math.min(minRow, r);
                    minCol = Math.min(minCol, c);
                }
            }
        }

        if (pos.size() < 2)
            return false;

        for (int[] p : pos) {
            if (p[1] > minCol + k - 1)
                return true;
        }

        for (int[] p : pos) {
            if (p[0] > minRow + k - 1)
                return true;
        }

        return false;
    }

    private int getArea(int[][] sum, int r1, int c1, int r2, int c2) {
        return sum[r2 + 1][c2 + 1] - sum[r1][c2 + 1] - sum[r2 + 1][c1] + sum[r1][c1];
    }
}