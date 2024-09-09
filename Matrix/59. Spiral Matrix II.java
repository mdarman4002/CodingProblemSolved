class Solution {
    public int[][] generateMatrix(int n) {
        int minRow = 0;
        int minColumn = 0;
        int maxRow = n - 1;
        int maxColumn = n - 1;
        int count = 1;
        int[][] matrix = new int[n][n];
        
        while (count <= n * n) {
            // First row
            for (int i = minColumn; i <= maxColumn; i++) {
                matrix[minRow][i] = count;
                count++;
            }
            minRow++;
            
            // Last column
            for (int i = minRow; i <= maxRow; i++) {
                matrix[i][maxColumn] = count;
                count++;
            }
            maxColumn--;
            
            // Last row
            for (int i = maxColumn; i >= minColumn; i--) {
                matrix[maxRow][i] = count;
                count++;
            }
            maxRow--;
            
            // First column
            for (int i = maxRow; i >= minRow; i--) {
                matrix[i][minColumn] = count;
                count++;
            }
            minColumn++;
        }
        
        return matrix;
    }
}
