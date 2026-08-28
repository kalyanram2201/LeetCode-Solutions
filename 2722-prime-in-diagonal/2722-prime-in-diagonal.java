class Solution {
    public int diagonalPrime(int[][] nums) {
        int result = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = nums[i][i];
            if (isPrime(val)) {
                result = Math.max(result, val);
            }
        }

        for (int i = 0; i < n; i++) {
            int val = nums[i][n - 1 - i];
            if (isPrime(val)) {
                result = Math.max(result, val);
            }
        }

        return result;
    }

    boolean isPrime(int val) {
        if (val < 2)
            return false;
        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0)
                return false;
        }
        return true;
    }
}
