class Solution {
    int ans = 0;
    int nonObstacle = 1;

    // DFS function to explore all paths from the starting position
    void dfs(int i, int j, int[][] grid, int count) {
        // Base condition: Agar hum grid ke bahar chale jayein ya obstacle pe aa jayein, to wapas chale jayein
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }

        // Agar hum destination par pahuch gaye
        if (grid[i][j] == 2) {
            // Agar humne sabhi non-obstacle cells cover kar liye hain, to answer increment karo
            if (count == nonObstacle) {
                ans++;
            }
            return;
        }

        // Current cell ko visited mark karo
        grid[i][j] = -1;

        // Four directions mein DFS call karo
        dfs(i + 1, j, grid, count + 1);
        dfs(i - 1, j, grid, count + 1);
        dfs(i, j + 1, grid, count + 1);
        dfs(i, j - 1, grid, count + 1);

        // Backtrack karke cell ko phir se unvisited bana do
        grid[i][j] = 0;
    }

    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;

        // Starting position aur non-obstacle cells count karo
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    nonObstacle++;
                }
            }
        }

        // DFS ko start position se call karo
        dfs(startX, startY, grid, 0);

        return ans;
    }
}
