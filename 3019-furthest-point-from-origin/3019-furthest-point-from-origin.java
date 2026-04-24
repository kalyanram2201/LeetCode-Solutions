class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0;
        int n = moves.length();
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') {
                l++;
            } else if (ch == 'R') {
                r++;
            }
        }
        if (l >= r) {
            l += n - l - r;
            return l - r;
        } else if (l < r) {
            r += n - r - l;
            return r - l;
        }
        return n;
    }
}