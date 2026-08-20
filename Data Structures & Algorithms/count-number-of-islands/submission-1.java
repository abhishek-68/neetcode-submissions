class Solution {
    class Pair {
        int row;
        int col;
        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    private void bfs(int r, int c, char[][] grid, int[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        vis[r][c] = 1;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));

        // 4 directions: Up, Right, Down, Left
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();

            for(int i=0; i<4; i++) {
                int nrow = row + dRow[i];
                int ncol = col + dCol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    if (vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                        vis[nrow][ncol] = 1;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return cnt;
    }
}