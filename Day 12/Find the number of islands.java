class Solution {
    boolean isSafe(char M[][], int row, int col, boolean visited[][], int ROW,
                   int COL) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) &&
               (M[row][col] == '1' && !visited[row][col]);
    }
    
    void DFS(char M[][], int row, int col, boolean visited[][], int ROW,
             int COL) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (grid[i][j] == '1' && !visited[i][j]) // If a cell with
                {                                        // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(grid, i, j, visited, ROW, COL);
                    ++count;
                }

        return count;
    }
}
