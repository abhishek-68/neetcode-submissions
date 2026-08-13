class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row + col
        boolean[] diag2 = new boolean[2 * n - 1]; // row - col + n - 1

        backtrack(0, n, board, col, diag1, diag2, ans);
        return ans;
    }

    private void backtrack(int row, int n, char[][] board, 
                            boolean[] col, boolean[] diag1, boolean[] diag2, 
                            List<List<String>> ans) {
        if (row == n) {
            List<String> curr = new ArrayList<>();
            for (char[] r : board) {
                curr.add(new String(r));
            }
            ans.add(curr);
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = row - c + n - 1;

            if (col[c] || diag1[d1] || diag2[d2]) continue; // not safe, skip

            // place queen
            board[row][c] = 'Q';
            col[c] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n, board, col, diag1, diag2, ans);

            // backtrack
            board[row][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}