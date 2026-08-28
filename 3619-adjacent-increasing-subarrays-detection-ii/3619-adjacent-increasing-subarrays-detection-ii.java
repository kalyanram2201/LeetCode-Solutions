class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int left = 1, right = n / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (adjacent(nums, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    boolean adjacent(List<Integer> nums, int k) {
        if (k - 1 == 0) {
            return true;
        }
        int exit = k - 1;
        for (int i = k + 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1) && nums.get(i - k) > nums.get(i - k - 1)) {
                exit--;
            } else {
                exit = k - 1;
            }
            
            if (exit == 0)
                return true;
        }
        return false;
    }
}