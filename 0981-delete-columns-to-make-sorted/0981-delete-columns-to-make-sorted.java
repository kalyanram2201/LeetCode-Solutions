class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length(), n = strs.length;
        int delete = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    delete++;
                    break;
                }
            }
        }
        return delete;
    }
}