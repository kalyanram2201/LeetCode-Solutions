class Solution {
    List<Integer> x = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        Nqueens(result, n, 1);
        return result;
    }

    void Nqueens(List<List<String>> list, int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x.add(i);
                if (k == n) {
                    list.add(printlist(x, n));
                } else {
                    Nqueens(list, n, k + 1);
                }
                x.remove(x.size() - 1);
            }
        }
    }

    boolean place(int k, int i) {
        for (int j = 1; j <= k - 1; j++) {
            int prevCol = x.get(j - 1);
            if (prevCol == i || Math.abs(prevCol - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    List<String> printlist(List<Integer> x, int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                if (x.get(i - 1) == j)
                    row.append('Q');
                else
                    row.append('.');
            }
            temp.add(row.toString());
        }
        return temp;
    }
}
