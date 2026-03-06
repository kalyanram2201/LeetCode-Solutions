class Solution {
    public boolean checkOnesSegment(String s) {
        if (s.charAt(0) == '0')
            return false;
        int n = s.length();
        boolean zero = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1' && zero) {
                return false;
            } else if (s.charAt(i) == '0') {
                zero = true;
            }
        }
        return true;
    }
}