/**
 * Solution class for spiral order traversal of a matrix
 */
class Solution {
    /**
     * Returns the spiral order traversal of a matrix
     * 
     * @param matrix 2D array of integers
     * @return List of integers in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        // Get the number of rows and columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize the top, bottom, left, and right boundaries
        int toprow = 0;
        int bottomrow = m - 1; // row
        int leftcol = 0;
        int rightcol = n - 1; // col

        /**
         * Loop until we have traversed the entire matrix
         */
        while (toprow <= bottomrow && leftcol <= rightcol) {
            /**
             * Traverse from left to right
             */
            for (int col = leftcol; col <= rightcol; col++) {
                int val = matrix[toprow][col];
                list.add(val);
            }
            toprow++;

            /**
             * Traverse from top to bottom
             */
            for (int row = toprow; row <= bottomrow; row++) {
                int val = matrix[row][rightcol];
                list.add(val);
            }
            rightcol--;

            /**
             * Check if we need to traverse from right to left
             */
            if (toprow <= bottomrow) {
                for (int col = rightcol; col >= leftcol; col--) {
                    int val = matrix[bottomrow][col];
                    list.add(val);
                }
                bottomrow--;
            }

            /**
             * Check if we need to traverse from bottom to top
             */
            if (rightcol >= leftcol) {
                for (int row = bottomrow; row >= toprow; row--) {
                    int val = matrix[row][leftcol];
                    list.add(val);
                }
                leftcol++;
            }
        }
        return list;
    }
}
