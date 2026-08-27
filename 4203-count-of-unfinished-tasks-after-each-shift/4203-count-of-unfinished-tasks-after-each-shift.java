class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] prefix = new long[n];

        prefix[0] = tasks[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + tasks[i];
        }

        long total = prefix[n - 1];
        long progress = 0;

        int[] ans = new int[shifts.length];

        for (int i = 0; i < shifts.length; i++) {
            progress += shifts[i];

            if (progress >= total) {
                ans[i] = 0;
                progress = 0;
                continue;
            }

            int idx = firstGreater(prefix, progress);
            ans[i] = n - idx;
        }

        return ans;
    }

    private int firstGreater(long[] prefix, long target) {
        int l = 0, r = prefix.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (prefix[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return l;
    }
}