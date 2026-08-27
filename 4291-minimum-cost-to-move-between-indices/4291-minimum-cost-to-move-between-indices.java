class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] closest = new int[n];

        for (int i = 0; i < n; i++) {
            int left = i > 0 ? nums[i] - nums[i - 1] : Integer.MAX_VALUE;
            int right = i < n - 1 ? nums[i + 1] - nums[i] : Integer.MAX_VALUE;

            if (left <= right)
                closest[i] = i - 1;
            else
                closest[i] = i + 1;
        }
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (closest[i - 1] == i) {
                right[i] = right[i - 1] + 1;
            } else {
                right[i] = right[i - 1] + (nums[i] - nums[i - 1]);
            }
        }

        int[] left = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (closest[i + 1] == i) {
                left[i] = left[i + 1] + 1;
            } else {
                left[i] = left[i + 1] + (nums[i + 1] - nums[i]);
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l < r) {
                ans[i] = right[r] - right[l];
            } else {
                ans[i] = left[r] - left[l];
            }
        }

        return ans;
    }
}