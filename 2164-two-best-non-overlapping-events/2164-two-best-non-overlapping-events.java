class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int n = events.length;
        int[] maxTill = new int[n];
        maxTill[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxTill[i] = Math.max(maxTill[i - 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int val = events[i][2];
            int idx = binarySearch(events, i);
            if (idx != -1) {
                val += maxTill[idx];
            }
            ans = Math.max(ans, val);
        }
        return ans;
    }

    private int binarySearch(int[][] events, int i) {
        int lo = 0, hi = i - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (events[mid][1] < events[i][0]) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
