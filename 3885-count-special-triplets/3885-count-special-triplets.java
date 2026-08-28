class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007, m = 100001;
        int[] freq = new int[m], left = new int[m];
        for (int x : nums)
            freq[x]++;

        long ans = 0;
        left[nums[0]]++;

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i], d = x << 1;
            if (d < m) {
                long l = left[d];
                long r = freq[d] - left[d] - (x == d ? 1 : 0);
                ans += l * r;
            }
            left[x]++;
        }
        return (int) (ans % mod);
    }
}
