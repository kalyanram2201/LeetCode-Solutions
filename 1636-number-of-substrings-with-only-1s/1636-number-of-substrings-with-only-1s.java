class Solution {
    public int numSub(String s) {
        int result = 0, count = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result = (int)((result + (count * (count + 1L) / 2) % mod) % mod);
                count = 0;
            } else {
                count++;
            }
        }

        result = (int)((result + (count * (count + 1L) / 2) % mod) % mod);
        return result;
    }
}
