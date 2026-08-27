class Solution {
    public long maxPairStrength(int[] nums) {
        long res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long g = gcd(nums[i], nums[j]);
                long val = (1L * nums[i] * nums[j]) / (g * g);
                res = Math.max(res, val);
            }
        }

        return res;
    }

    long gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}