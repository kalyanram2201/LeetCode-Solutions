class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidSudoku(i, j, board, num)) {
                            board[i][j] = num;
                            if (backtrack(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(int i, int j, char[][] board, char val) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == val) return false;
            if (board[k][j] == val) return false;
        }
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (board[r][c] == val) return false;
            }
        }
        return true;
    }
}
