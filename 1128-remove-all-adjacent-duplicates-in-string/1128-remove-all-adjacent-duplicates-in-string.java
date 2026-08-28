class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = result.length();
            if (n != 0 && result.charAt(n - 1) == c) {
                result.deleteCharAt(n - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
