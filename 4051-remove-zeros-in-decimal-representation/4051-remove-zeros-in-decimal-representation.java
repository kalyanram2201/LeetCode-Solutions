class Solution {
    public long removeZeros(long n) {
        String str = Long.toString(n);
        long result = 0;
        for (char ch : str.toCharArray()) {
            if (ch != '0') {
                result = result * 10 + (ch - '0');
            }
        }
        return result;
    }
}