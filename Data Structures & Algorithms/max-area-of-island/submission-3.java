class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, int startRow, int startCol) {
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        // Enqueue and mark as visited immediately to prevent duplicate queuing
        queue.offer(new int[]{startRow, startCol});
        grid[startRow][startCol] = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            area++;

            for (int[] dir : directions) {
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];

                // Check boundary conditions and if cell is unvisited land
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                    grid[r][c] = 0; // Mark visited
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return area;
    }
}