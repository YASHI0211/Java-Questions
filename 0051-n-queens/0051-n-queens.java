class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(res, board, 0);
        return res;
    }
    private void backtrack(List<List<String>> res, char[][] board, int col) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(res, board, col + 1);
                board[i][col] = '.';
            }
        }
    }
    private boolean validate(char[][] b, int r, int c) {
        for (int i = 0; i < c; i++) if (b[r][i] == 'Q') return false;
        for (int i=r, j=c; i>=0 && j>=0; i--, j--) if (b[i][j] == 'Q') return false;
        for (int i=r, j=c; j>=0 && i<b.length; i++, j--) if (b[i][j] == 'Q') return false;
        return true;
    }
    private List<String> construct(char[][] b) {
        List<String> s = new ArrayList<>();
        for (char[] row : b) s.add(new String(row));
        return s;
    }
}