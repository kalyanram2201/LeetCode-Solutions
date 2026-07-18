class Solution {
    public String rearrangeString(String s, char x, char y) {
        int xc = 0, yc = 0;
        for (char ch : s.toCharArray()) {
            if (ch == x) {
                xc++;
            } else if (ch == y) {
                yc++;
            }
        }
        if (xc == 0 || yc == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < yc; i++) {
            sb.append(y);
        }

        for (int i = 0; i < xc; i++) {
            sb.append(x);
        }
        for (char ch : s.toCharArray()) {
            if (ch != x && ch != y) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}