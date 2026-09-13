class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int[] arr = new int[256];

        for (char ch : t.toCharArray()) {
            arr[ch]++;
        }

        int l = 0, count = 0;
        int ind = -1, res = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            if (arr[s.charAt(r)] > 0)
                count++;

            arr[s.charAt(r)]--;

            while (count == m) {
                if ((r - l + 1) < res) {
                    res = r - l + 1;
                    ind = l;
                }

                arr[s.charAt(l)]++;
                if (arr[s.charAt(l)] > 0)
                    count--;

                l++;
            }
        }

        return ind == -1 ? "" : s.substring(ind, ind + res);
    }
}