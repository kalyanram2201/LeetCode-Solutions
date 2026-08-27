class Solution {
    public boolean judgeCircle(String moves) {
        int r = 0, u = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U')
                u++;
            else if (ch == 'D')
                u--;
            else if (ch == 'R')
                r++;
            else
                r--;
        }
        return r == 0 && u == 0;
    }
}