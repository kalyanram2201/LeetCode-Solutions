class Solution {
    public int vowelConsonantScore(String s) {
        String vowel = "aeiou";
        int v = 0, c = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ' || Character.isDigit(ch))
                continue;
            if (vowel.indexOf(ch) != -1) {
                v++;
            } else {
                c++;
            }
        }
        return c > 0 ? v / c : 0;
    }
}