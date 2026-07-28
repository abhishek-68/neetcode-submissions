class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                // Encode unique keys for row, column, and 3x3 box
                String rowKey = val + " in row " + r;
                String colKey = val + " in col " + c;
                String boxKey = val + " in box " + (r / 3) + "-" + (c / 3);

                // .add() returns false if the item is already present
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}