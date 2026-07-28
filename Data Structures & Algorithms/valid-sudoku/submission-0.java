class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length; // row
        int n = board[0].length; // col

        // check all rows
        for(int row=0; row<m; row++) {
            Set<Character> st = new HashSet<>();

            for(int col=0; col<n; col++) {
                if(board[row][col] == '.') continue;
                if(st.contains(board[row][col])) return false;
                st.add(board[row][col]);
            }
        }
         
        // check all colums
        for(int col=0; col<n; col++) {
            Set<Character> st = new HashSet<>();

            for(int row=0; row<m; row++) {
                if(board[row][col] == '.') continue;
                if(st.contains(board[row][col])) return false;
                st.add(board[row][col]);
            }
        }

        // 3. Check all 3x3 sub-boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> st = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (board[row][col] == '.') continue;
                        if (st.contains(board[row][col])) return false;
                        st.add(board[row][col]);
                    }
                }
            }
        }

        return true;
    }
}
