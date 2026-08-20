class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited by sinking the land
        grid[row][col] = 0;

        // Sum 1 (current cell) + all 4 adjacent directions
        return 1 + dfs(grid, row - 1, col)
                 + dfs(grid, row + 1, col)
                 + dfs(grid, row, col - 1)
                 + dfs(grid, row, col + 1);
    }
}