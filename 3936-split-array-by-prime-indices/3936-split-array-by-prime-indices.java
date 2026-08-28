class Solution {
    public long splitArray(int[] nums) {
        long sumA = 0, sumB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= 1 || (i % 2 == 0 && i != 2)) {
                sumB += nums[i];
            } else if (isPrime(i)) {
                sumA += nums[i];
            } else {
                sumB += nums[i];
            }
        }
        return Math.abs(sumA - sumB);
    }

    boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i++) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}