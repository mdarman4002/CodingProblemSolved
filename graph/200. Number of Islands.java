/**
 * Solution class to count the number of islands in a given grid.
 */
class Solution {
    /**
     * Number of rows in the grid.
     */
    int n = 0;
    /**
     * Number of columns in the grid.
     */
    int m = 0;

    /**
     * Method to count the number of islands in the grid.
     * 
     * @param grid 2D array representing the grid, where '1' represents land and '0' represents water.
     * @return The number of islands in the grid.
     */
    public int numIslands(char[][] grid) {
        /**
         * Initialize the number of rows and columns in the grid.
         */
        n = grid.length;
        m = grid[0].length;
        
        /**
         * Initialize the count of islands.
         */
        int count = 0;
        
        /**
         * Iterate through each cell in the grid.
         */
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                /**
                 * If the current cell is a land cell ('1'), perform a depth-first search (DFS) to mark all connected land cells as visited.
                 */
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    /**
                     * Increment the count of islands.
                     */
                    count++;
                }
            }
        }
        /**
         * Return the total count of islands.
         */
        return count;
    }

    /**
     * Depth-first search (DFS) method to mark all connected land cells as visited.
     * 
     * @param grid 2D array representing the grid.
     * @param i    Current row index.
     * @param j    Current column index.
     */
    public void dfs(char grid [][], int i, int j){
        /**
         * Base case: If the current cell is out of bounds or is not a land cell ('1'), return immediately.
         */
        if(i<0 || j < 0 || i >=n || j >=m || grid[i][j] != '1'){
            return ;
        }
        
        /**
         * Mark the current cell as visited by setting it to '2'.
         */
        grid[i][j] = '2';
       // if(grid[i][j] == '0' || grid[i][j] == '2'){
        //     return;
        // }
        
        /**
         * Recursively visit all adjacent land cells.
         */
        dfs(grid, i+1, j); // Visit bottom cell
        dfs(grid, i-1, j); // Visit top cell
        dfs(grid, i, j+1); // Visit right cell
        dfs(grid, i, j-1); // Visit left cell
    }
}
