class Solution {
    int count = 0;
    List<Integer> x = new ArrayList<>();

    public int totalNQueens(int n) {
        if (n <= 0)
            return 0;
        NQueen(n, 0);
        return count;
    }

    void NQueen(int n, int k) {
        if (k == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (place(k, i)) {
                x.add(i);
                NQueen(n, k + 1);
                x.remove(x.size() - 1);
            }
        }
    }

    boolean place(int k, int i) {
        for (int j = 0; j < k; j++) {
            int col = x.get(j);
            if (col == i || Math.abs(col - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }
}
