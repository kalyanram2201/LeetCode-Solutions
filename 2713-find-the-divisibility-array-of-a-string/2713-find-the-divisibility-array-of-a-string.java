class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] result = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int val = word.charAt(i) - '0';
            sum = (sum * 10 + val) % m;
            if (sum == 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}