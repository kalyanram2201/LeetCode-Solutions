class Solution {
    public String removeOuterParentheses(String s) {
        String res = "";
        int lvl = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c == '(' && lvl++ > 0) || (c == ')' && --lvl > 0))
                res += c;

        }

        return res;
    }
}