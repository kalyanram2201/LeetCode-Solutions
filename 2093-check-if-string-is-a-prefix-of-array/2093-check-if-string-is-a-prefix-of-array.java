class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int j = 0;
        for (String word : words) {
            if (j + word.length() > s.length()) {
                return false;
            }
            String temp = s.substring(j, j + word.length());
            if (!temp.equals(word)) {
                return false;
            }
            j += word.length();
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }
}
