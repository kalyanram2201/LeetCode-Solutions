class Solution {
    public int sumBase(int n, int k) {
        if (n < k) return n;

        StringBuilder result = new StringBuilder();
        while (n != 0) {
            result.append(n % k);
            n = n / k;
        }

        int sum = 0;
        for (char c : result.toString().toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}
