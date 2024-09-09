/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Solution class for spiral matrix problem
 */
class Solution {
    /**
     * Method to fill a spiral matrix with values from a linked list
     * 
     * @param m number of rows in the matrix
     * @param n number of columns in the matrix
     * @param head head of the linked list
     * @return a 2D array representing the spiral matrix
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        /**
         * Initialize the matrix with -1 values
         */
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        /**
         * Initialize the boundaries of the matrix
         */
        int topRow = 0; int bottomRow = m - 1; // row
        int leftColumn = 0; int rightColumn = n - 1; // col

        /**
         * Iterate through the linked list and fill the matrix in a spiral order
         */
        while (head != null) {
            // Top row
            for (int col = leftColumn; col <= rightColumn; col++) {
                if (head == null) break;
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;

            // Right column
            for (int row = topRow; row <= bottomRow; row++) {
                if (head == null) break;
                matrix[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;

            // Bottom row
            for (int col = rightColumn; col >= leftColumn; col--) {
                if (head == null) break;
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

            // Left column
            for (int row = bottomRow; row >= topRow; row--) {
                if (head == null) break;
                matrix[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;
        }

        return matrix;
    }
}
