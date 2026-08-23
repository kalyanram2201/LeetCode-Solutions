class Solution {
    public boolean isPalindromic(String s) {
        String res = "";
        for (char ch : s.toCharArray()) {
            int ascii = ch;
            String binary8 = String.format("%8s", Integer.toBinaryString(ascii))
                    .replace(' ', '0');
            res += binary8;
        }
        int r = res.length() - 1, l = 0;
        while (l <= r) {
            if (res.charAt(l) != res.charAt(r)) {
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
}