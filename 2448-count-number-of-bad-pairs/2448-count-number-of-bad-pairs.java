class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer>mpp = new HashMap<>();
        long count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count += -1 +mpp.merge(nums[i] - i, 1, Integer::sum);
        }
        return 1L * n * (n - 1) / 2 - count;
    }
}