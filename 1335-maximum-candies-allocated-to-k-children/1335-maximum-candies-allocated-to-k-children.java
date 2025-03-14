class Solution {
    public int maximumCandies(int[] candies, long k) {
        if (k == 0) return 0;

        int left = 1, right = (int)1e7;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0;
        for (int c : candies) {
            count += c / mid;
        }
        return count >= k;
    }
}
