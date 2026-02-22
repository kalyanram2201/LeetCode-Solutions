class Solution {
    public int binaryGap(int n) {
        int length = 0, count = 0;
        String bit = binary(n);
        for (char ch : bit.toCharArray()) {
            if (ch == '1') {
                length = Math.max(length, count);
                count = 1;
            } else {
                count++;
            }
        }
        return length;

    }

    String binary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }
}