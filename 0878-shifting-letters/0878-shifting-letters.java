class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        int[] sum = new int[n];
        int shift = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            sum[i] = shift;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int shifted = (c - 'a' + sum[i]) % 26;
            sb.append((char) ('a' + shifted));
        }

        return sb.toString();
    }
}
