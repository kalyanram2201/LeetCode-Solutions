class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char val = board[i][j];
                if (val == '.') {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (k != j && board[i][k] == val) {
                        return false;
                    }
                }
                for (int k = 0; k < n; k++) {
                    if (k != i && board[k][j] == val) {
                        return false;
                    }
                }
                int row = (i / 3) * 3;
                int col = (j / 3) * 3;
                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        if ((r != i || c != j) && board[r][c] == val) {
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}