class Solution {
    public boolean f(int i, ArrayList<Integer> list, int val, Boolean[][] dp) {
        if (val == 0) {
            return true;
        }
        if (val < 0 || i == list.size())
            return false;
        if (dp[i][val] != null)
            return dp[i][val];
        boolean pick = f(i + 1, list, val - list.get(i), dp);

        boolean notpick = f(i + 1, list, val, dp);

        dp[i][val] = pick || notpick;
        return pick || notpick;
    }

    public boolean check(int x, int[] nums, int[][] queries) {
        int n = nums.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < x; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            for (int j = l; j <= r; j++) {
                if (nums[j] > 0) {
                    list.get(j).add(val);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;
            ArrayList<Integer> cur = list.get(i);

            Boolean[][] dp = new Boolean[cur.size()][nums[i] + 1];
            if (!f(0, cur, nums[i], dp)) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int low = 0;
        int high = q - 1;
        if (!check(q, nums, queries))
            return -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, nums, queries)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}