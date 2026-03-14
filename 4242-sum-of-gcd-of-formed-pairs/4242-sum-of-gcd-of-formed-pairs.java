class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length, max = 0;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            prefix[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefix);
        int l = 0, r = n - 1;
        long result = 0;
        while (l < r) {
            result += gcd(prefix[l], prefix[r]);
            l++;
            r--;
        }
        return result;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}