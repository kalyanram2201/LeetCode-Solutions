class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int diff1 = 0, diff2 = 0, res = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < str.length(); r++) {
            if (str.charAt(r) != (r % 2 == 0 ? '0' : '1'))
                diff1++;
            if (str.charAt(r) != (r % 2 == 0 ? '1' : '0'))
                diff2++;

            if (r - l + 1 > n) {
                if (str.charAt(l) != (l % 2 == 0 ? '0' : '1'))
                    diff1--;
                if (str.charAt(l) != (l % 2 == 0 ? '1' : '0'))
                    diff2--;
                l++;
            }

            if (r - l + 1 == n) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}