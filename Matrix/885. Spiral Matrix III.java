class Solution {
    /**
     * Generates a spiral matrix of size rows x cols starting from the point (rStart, cStart).
     * 
     * @param rows The number of rows in the matrix.
     * @param cols The number of columns in the matrix.
     * @param rStart The starting row index.
     * @param cStart The starting column index.
     * @return A 2D array of integers, where each inner array represents a point in the spiral matrix.
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        /**
         * Array to store the possible directions to move in the matrix (right, down, left, up).
         * Each direction is represented as an array of two integers, where the first integer is the row offset and the second integer is the column offset.
         */
        int[][] directions = {
            // right, down, left, up
            //{row i, column j}
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        
        /**
         * Total number of points in the matrix.
         */
        int n = rows * cols;
        
        /**
         * 2D array to store the points in the spiral matrix.
         */
        int[][] result = new int[n][2];
        
        /**
         * Initialize the first point in the result array to (rStart, cStart).
         */
        result[0][0] = rStart;
        result[0][1] = cStart;
        
        /**
         * Counter to keep track of the number of points generated.
         */
        int count = 1;
        
        /**
         * Variable to control the number of steps in each direction.
         */
        int step = 1;
        
        /**
         * Index to keep track of the current direction.
         */
        int index = 0;
        
        /**
         * Loop until count reaches the total number of points in the matrix.
         */
        while (count < n) {
            for (int times = 0; times < 2; times++) {
                /**
                 * Get the current direction.
                 */
                int dr = directions[index % 4][0];
                int dc = directions[index % 4][1];
                
                /**
                 * Move in the current direction for step steps.
                 */
                for (int i = 0; i < step; i++) {
                    rStart += dr;
                    cStart += dc;
                    
                    /**
                     * Check if the new point is within the matrix boundaries.
                     */
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        /**
                         * Add the new point to the result array.
                         */
                        result[count][0] = rStart;
                        result[count][1] = cStart;
                        count++;
                    }
                }
                index++;
            }
            step++;
        }
        
        return result;
    }
}
