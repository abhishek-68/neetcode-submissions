class Solution {
    /*
        here i represents the row and j represents the column
    */

    private boolean isSafe(char[][] board, int i, int j) {
        // check column (rows above, same column)
        for (int r = i - 1; r >= 0; r--) {
            if (board[r][j] == 'Q') return false;
        }

        // check upper-left diagonal
        for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }

        // check upper-right diagonal
        for (int r = i - 1, c = j + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }

        return true;
    }

    private void backtrack(int i, char[][] board, List<List<String>> ans) {
        if(i == board.length) {
            List<String> curr = new ArrayList<>();
            for(char[] row : board) {
                curr.add(new String(row));
            }
            ans.add(curr);
            return;
        }

        for(int j=0; j<board[0].length; j++) {
            if(isSafe(board, i, j)) {
                board[i][j] = 'Q';
                backtrack(i+1, board, ans);
                board[i][j] = '.'; // backtrack step
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, board, ans);
        return ans;
    }
}
