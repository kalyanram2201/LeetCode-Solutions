class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n - 1; i++) {
                int val1 = s.charAt(i) - '0';
                int val2 = s.charAt(i + 1) - '0';
                sb.append((val1 + val2) % 10);
            }

            s = sb.toString();
        }

        return s.length() == 2 && s.charAt(0) == s.charAt(1);
    }
}
