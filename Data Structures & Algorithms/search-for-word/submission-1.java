class Solution {
    private int ROW, COL;

    private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] vis) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= ROW || j >= COL) {
            return false;
        }

        if (board[i][j] != word.charAt(idx) || vis[i][j] == true) {
            return false;
        }

        vis[i][j] = true; 

        boolean result = dfs(board, word, i + 1, j, idx + 1, vis) ||
                        dfs(board, word, i - 1, j, idx + 1, vis) ||
                        dfs(board, word, i, j + 1, idx + 1, vis) ||
                        dfs(board, word, i, j - 1, idx + 1, vis);

        vis[i][j] = false; // Backtrack

        return result;
    }

    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;

        boolean[][] vis = new boolean[ROW][COL];

        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(dfs(board, word, i, j, 0, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
