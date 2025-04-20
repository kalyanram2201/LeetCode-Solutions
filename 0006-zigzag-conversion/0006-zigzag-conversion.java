class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        char[][] result = new char[numRows][s.length()];
        int j = 0, i = 0, k = 0;
        boolean down = true;

        while (k < s.length()) {
            if (down) {
                while (i < numRows && k < s.length()) {
                    result[i++][j] = s.charAt(k++);
                }
                i -= 2;
                j++;
                down = false;
            } else {
                while (i >= 0 && k < s.length()) {
                    result[i--][j++] = s.charAt(k++);
                }
                i += 2;
                down = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] temp : result) {
            for (char temp2 : temp) {
                if (temp2 != '\u0000') {
                    sb.append(temp2);
                }
            }
        }
        return sb.toString();
    }
}
