class Solution {
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        int count = 0;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int t = current[2];
            
            for (int i = 0; i < 4; i++) {
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];
                
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.offer(new int[]{nrow, ncol, t + 1});
                    vis[nrow][ncol] = 1;
                    count++;
                    time = Math.max(time, t + 1);
                }
            }
        }
        
        if (count != fresh) {
            return -1;
        }
        
        return time;
    }
}