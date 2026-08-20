class Solution {

    class Pair {
        int row;
        int col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    private void bfs(int r, int c, char[][] grid, int[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        vis[r][c] = 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));

        while(!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();

            for(int delRow = -1; delRow<=1; delRow++) {
                for(int delCol=-1; delCol<=1; delCol++) {
                    // Only process 4-directional moves (up, down, left, right)
                    if (Math.abs(delRow) + Math.abs(delCol) != 1) {
                        continue;
                    }
                    int nrow = row + delRow;
                    int ncol = col + delCol;

                    if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                        vis[nrow][ncol] = 1;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;

        int[][] vis = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return cnt;
    }
}
