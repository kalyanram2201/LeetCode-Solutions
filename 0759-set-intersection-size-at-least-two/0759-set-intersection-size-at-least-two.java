class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int p = -1, q = -1, ans = 0;

        for (int[] in : intervals) {
            int start = in[0], end = in[1];

            boolean hasP = p >= start && p <= end;
            boolean hasQ = q >= start && q <= end;

            if (hasP && hasQ)
                continue;

            if (hasQ) {
                ans++;
                p = q;
                q = end;
            } else {
                ans += 2;
                p = end - 1;
                q = end;
                if (p < start)
                    p = start;
            }
        }

        return ans;
    }
}
