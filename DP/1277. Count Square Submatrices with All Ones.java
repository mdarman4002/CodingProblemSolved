class Solution {
    /**
     * This method counts the number of square submatrices with all ones in a given binary matrix.
     * 
     * @param matrix A 2D binary matrix where each element is either 0 or 1.
     * @return The total number of square submatrices with all ones.
     */
    public int countSquares(int[][] matrix) {
        // Get dimensions of the matrix
        int n = matrix.length;    // number of rows
        int m = matrix[0].length; // number of columns
        
        // Create a DP table with the same dimensions as the matrix
        int[][] dp = new int[n][m];
        
        // Variable to store total count of squares
        int ans = 0;
        
        // Initialize the first column of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0]; // If the cell in the matrix is 1, it can form a 1x1 square
            ans += dp[i][0]; // Add to the total count
        }
        
        // Initialize the first row of the DP table
        for (int j = 1; j < m; j++) {
            dp[0][j] = matrix[0][j]; // If the cell in the matrix is 1, it can form a 1x1 square
            ans += dp[0][j]; // Add to the total count
        }
        
        // Fill the DP table for remaining cells
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // Check if the current cell in the matrix is 1
                if (matrix[i][j] == 1) {
                    // The value in dp[i][j] is the minimum of the three neighboring cells plus one
                    // This indicates the largest square submatrix that can be formed with (i, j) as the bottom-right corner
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
                // Add the number of squares ending at (i, j) to the total count
                ans += dp[i][j];
            }
        }
        
        // Return the total count of square submatrices with all ones
        return ans;
    }
}
