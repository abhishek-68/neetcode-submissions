class Solution {
    public boolean searchMatrix(int[][] matrix, int T) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == T) {
                    return true;
                }
            }
        }

        return false;
    }
}
