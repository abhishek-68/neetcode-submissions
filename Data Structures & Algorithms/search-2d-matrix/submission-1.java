class Solution {
    public boolean searchMatrix(int[][] matrix, int T) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++) {
            int l = 0;
            int r = n - 1;

            while(l <= r) {
                int mid = l + (r - l)/2;

                if(matrix[i][mid] == T) {
                    return true;
                }

                if(matrix[i][mid] > T) {
                    r = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
        }

        return false;
    }
}
