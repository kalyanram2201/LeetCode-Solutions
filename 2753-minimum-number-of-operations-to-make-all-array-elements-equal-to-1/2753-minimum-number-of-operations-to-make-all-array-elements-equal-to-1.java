class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int num : nums) {
            if (num == 1)
                count++;
        }

        if (count > 0)
            return n - count;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : (min - 1) + (n - 1);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
