class Solution {
    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        backtrack(n, "", k);
        return ans;
    }

    void backtrack(int n, String str, int k) {
        if (str.length() == n) {
            count++;
            if (count == k)
                ans = str;
            return;
        }

        for (char c : new char[] { 'a', 'b', 'c' }) {
            if (str.length() == 0 || str.charAt(str.length() - 1) != c) {
                backtrack(n, str + c, k);
                if (!ans.equals(""))
                    return;
            }
        }
    }
}