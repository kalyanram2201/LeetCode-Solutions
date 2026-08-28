class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int result = Integer.MAX_VALUE;
        boolean found = false;

        for (int right = l; right <= r; right++) {
            int sum = 0;

            for (int i = 0; i < right; i++) {
                sum += nums.get(i);
            }
            if (sum > 0) {
                result = Math.min(result, sum);
                found = true;
            }
            for (int i = right; i < n; i++) {
                sum += nums.get(i) - nums.get(i - right);
                if (sum > 0) {
                    result = Math.min(result, sum);
                    found = true;
                }
            }
        }

        return found ? result : -1;
    }
}
