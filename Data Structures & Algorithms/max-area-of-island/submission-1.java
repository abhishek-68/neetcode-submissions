class Solution {
    private int area;

    private void dfs(int row, int col, int[][] grid, int[][] vis) {
        area++;
        int m = grid.length;
        int n = grid[0].length;
        vis[row][col] = 1;

        // 4 directions: Up, Right, Down, Left
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + dRow[i];
            int ncol = col + dCol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        int[][] vis = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    area = 0;
                    dfs(i, j, grid, vis);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
}
