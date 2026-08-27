class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1_000_000_007;
        for (int[] q : queries) {
            int idx = q[0];
            while (idx <= q[1]) {
                nums[idx] = (int) ((1L * nums[idx] * q[3]) % mod);
                idx += q[2];
            }
        }

        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }
}
