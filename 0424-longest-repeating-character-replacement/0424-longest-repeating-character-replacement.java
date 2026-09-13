class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, freq = 0, l = 0;
        int n = s.length();
        int[] arr = new int[26];
        for (int r = 0; r < n; r++) {
            arr[s.charAt(r) - 'A']++;
            freq = Math.max(freq, arr[s.charAt(r) - 'A']);
            if ((r - l + 1) - freq > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}