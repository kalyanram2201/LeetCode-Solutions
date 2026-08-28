class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else if (s.charAt(i - 1) != s.charAt(i)) {
                count = 1;
            }

            if (count < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}