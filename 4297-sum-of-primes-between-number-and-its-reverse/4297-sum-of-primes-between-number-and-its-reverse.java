class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev = 0;
        int temp = n;

        while (temp > 0) {
            rev = rev * 10 + (temp % 10);
            temp /= 10;
        }

        int start = Math.min(n, rev);
        int end = Math.max(n, rev);

        boolean[] prime = new boolean[end + 1];

        for (int i = 2; i <= end; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= end; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    prime[j] = false;
                }
            }
        }

        int res = 0;
        for (int i = start; i <= end; i++) {
            if (prime[i]) {
                res += i;
            }
        }

        return res;
    }
}