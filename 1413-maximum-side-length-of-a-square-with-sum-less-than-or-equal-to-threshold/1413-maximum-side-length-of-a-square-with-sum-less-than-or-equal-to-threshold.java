class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (check(prefix, mid, threshold))
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    boolean check(int[][] p, int len, int t) {
        for (int i = len; i < p.length; i++) {
            for (int j = len; j < p[0].length; j++) {
                int sum = p[i][j] - p[i - len][j] - p[i][j - len] + p[i - len][j - len];
                if (sum <= t)
                    return true;
            }
        }
        return false;
    }
}
