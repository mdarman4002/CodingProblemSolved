
class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxMoves = 0;

        // Create a memoization table
        Integer[][] memo = new Integer[rows][cols];

        // Start from each cell in the first column
        for (int i = 0; i < rows; i++) {
            maxMoves = Math.max(maxMoves, findMaxMoves(grid, i, 0, memo));
        }
        
        return maxMoves;
    }

    private int findMaxMoves(int[][] grid, int row, int col, Integer[][] memo) {
        // Check bounds
        if (row < 0 || row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        // If we have already computed the result for this cell, return it
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int maxMovesFromCurrent = 0;

        // Check the three possible moves
        // Move to (row - 1, col + 1)
        if (row > 0 && col + 1 < grid[0].length && grid[row - 1][col + 1] > grid[row][col]) {
            maxMovesFromCurrent = Math.max(maxMovesFromCurrent, 1 + findMaxMoves(grid, row - 1, col + 1, memo));
        }
        
        // Move to (row, col + 1)
        if (col + 1 < grid[0].length && grid[row][col + 1] > grid[row][col]) {
            maxMovesFromCurrent = Math.max(maxMovesFromCurrent, 1 + findMaxMoves(grid, row, col + 1, memo));
        }
        
        // Move to (row + 1, col + 1)
        if (row < grid.length - 1 && col + 1 < grid[0].length && grid[row + 1][col + 1] > grid[row][col]) {
            maxMovesFromCurrent = Math.max(maxMovesFromCurrent, 1 + findMaxMoves(grid, row + 1, col + 1, memo));
        }

        // Store the result in the memoization table
        memo[row][col] = maxMovesFromCurrent;
        return maxMovesFromCurrent;
    }
}

------------------------other---------------------------------------
------------class TLE----------------
// class Solution {
//     public int maxMoves(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         int maxMoves = 0;

//         // Start from each cell in the first column
//         for (int i = 0; i < rows; i++) {
//             maxMoves = Math.max(maxMoves, findMaxMoves(grid, i, 0));
//         }
        
//         return maxMoves;
//     }

//     private int findMaxMoves(int[][] grid, int row, int col) {
//         // Check bounds: Ensure we don't go out of bounds
//         if (row < 0 || row >= grid.length || col >= grid[0].length) {
//             return 0;
//         }

//         int maxMovesFromCurrent = 0;

//         // Check the three possible moves only if col + 1 is within bounds
//         if (col + 1 < grid[0].length) {
//             // Move to (row - 1, col + 1)
//             if (row > 0 && grid[row - 1][col + 1] > grid[row][col]) {
//                 maxMovesFromCurrent = Math.max(maxMovesFromCurrent, 1 + findMaxMoves(grid, row - 1, col + 1));
//             }
            
//             // Move to (row, col + 1)
//             if (grid[row][col + 1] > grid[row][col]) {
//                 maxMovesFromCurrent = Math.max(maxMovesFromCurrent, 1 + findMaxMoves(grid, row, col + 1));
//             }
            
//             // Move to (row + 1, col + 1)
//             if (row < grid.length -1 && grid[row + 1][col + 1] > grid[row][col]) {
//                 maxMovesFromCurrent = Math.max(maxMovesFromCurrent, 1 + findMaxMoves(grid, row + 1, col + 1));
//             }
//         }

//         return maxMovesFromCurrent;
//     }
// }



 ----------------- class stack Solution TLE -----------------------

// import java.util.Stack;

// class Solution {
//     public int maxMoves(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         int maxMoves = 0;

//         // Start from each cell in the first column
//         for (int i = 0; i < rows; i++) {
//             maxMoves = Math.max(maxMoves, dfs(grid, i, 0));
//         }

//         return maxMoves;
//     }

//     private int dfs(int[][] grid, int startRow, int startCol) {
//         Stack<int[]> stack = new Stack<>();
//         stack.push(new int[]{startRow, startCol, 0}); // row, col, moves

//         int maxMovesFromCurrent = 0;

//         while (!stack.isEmpty()) {
//             int[] current = stack.pop();
//             int row = current[0];
//             int col = current[1];
//             int moves = current[2];

//             // Update max moves
//             maxMovesFromCurrent = Math.max(maxMovesFromCurrent, moves);

//             // Check the three possible moves
//             if (col + 1 < grid[0].length) {
//                 // Move to (row - 1, col + 1)
//                 if (row > 0 && grid[row - 1][col + 1] > grid[row][col]) {
//                     stack.push(new int[]{row - 1, col + 1, moves + 1});
//                 }

//                 // Move to (row, col + 1)
//                 if (grid[row][col + 1] > grid[row][col]) {
//                     stack.push(new int[]{row, col + 1, moves + 1});
//                 }

//                 // Move to (row + 1, col + 1)
//                 if (row < grid.length - 1 && grid[row + 1][col + 1] > grid[row][col]) {
//                     stack.push(new int[]{row + 1, col + 1, moves + 1});
//                 }
//             }
//         }

//         return maxMovesFromCurrent;
//     }
// }

-------------- DP class Solution ------------------

// class Solution {
//     public int maxMoves(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         int[][] dp = new int[rows][cols];

//         // Fill the last column with 0 moves since no further moves can be made from there
//         for (int i = 0; i < rows; i++) {
//             dp[i][cols - 1] = 0;
//         }

//         // Fill the DP table from right to left
//         for (int j = cols - 2; j >= 0; j--) {
//             for (int i = 0; i < rows; i++) {
//                 // Move straight right
//                 if (grid[i][j] < grid[i][j + 1]) {
//                     dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j + 1]);
//                 }
//                 // Move up-right
//                 if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
//                     dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j + 1]);
//                 }
//                 // Move down-right
//                 if (i < rows - 1 && grid[i][j] < grid[i + 1][j + 1]) {
//                     dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j + 1]);
//                 }
//             }
//         }

//         // Find the maximum moves starting from the first column
//         int maxMoves = 0;
//         for (int i = 0; i < rows; i++) {
//             maxMoves = Math.max(maxMoves, dp[i][0]);
//         }

//         return maxMoves;
//     }
// }
