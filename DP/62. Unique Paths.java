// class Solution {
//     int pathcount = 0;

//     public int uniquePaths(int m, int n) {
//         path(m, n, 0, 0);
//         return pathcount;
//     }

//     public void path(int m, int n, int row, int col) {
//         if (row == m - 1 && col == n - 1) {
//             pathcount++;
//             return;
//         }

//         if (row < m - 1) {
//             path(m, n, row + 1, col); // down
//         }
//         if (col < n - 1) {
//             path(m, n, row, col + 1); // right
//         }
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 1D array to store the number of unique paths for each column
        int[] dp = new int[n];
        // Initialize the first row (which is all 1s, as there's only one way to reach any cell in the first row)
        Arrays.fill(dp, 1);

        // Iterate over each row starting from the second row
        for (int i = 1; i < m; i++) {
            // Update the dp array for the current row
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        // The last element in the dp array contains the number of unique paths to the bottom-right corner
        return dp[n - 1];
    }
}
