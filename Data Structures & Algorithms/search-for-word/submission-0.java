class Solution {
    private int ROW, COL;

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= ROW || j >= COL) {
            return false;
        }
        // Fixed: changed word.charAt(i) to word.charAt(idx)
        if (board[i][j] != word.charAt(idx) || board[i][j] == '!') {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '!'; 

        boolean result = dfs(board, word, i + 1, j, idx + 1) ||
                        dfs(board, word, i - 1, j, idx + 1) ||
                        dfs(board, word, i, j + 1, idx + 1) ||
                        dfs(board, word, i, j - 1, idx + 1);

        board[i][j] = temp; // Backtrack

        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;

        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
