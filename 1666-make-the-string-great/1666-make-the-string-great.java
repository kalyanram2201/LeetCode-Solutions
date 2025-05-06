class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = result.length();
            if (n > 0 && Math.abs(result.charAt(n - 1) - c) == 32) {
                result.deleteCharAt(n - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
