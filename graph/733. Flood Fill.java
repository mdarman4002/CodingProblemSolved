/**
 * Solution class for the flood fill problem.
 */
class Solution {
    /**
     * Performs a flood fill operation on an image.
     * 
     * @param image  The input image represented as a 2D array of integers.
     * @param sr     The row index of the starting pixel.
     * @param sc     The column index of the starting pixel.
     * @param color  The new color to fill the image with.
     * @return The modified image after the flood fill operation.
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Store the original color of the starting pixel
        int originalColor = image[sr][sc];
        
        // If the original color is the same as the target color, return the image immediately
        if (originalColor == color) return image; // no need to fill if color is the same
        
        // Call the dfsFloodFill method to perform the flood fill operation
        dfsFloodFill(image, sr, sc, color, originalColor);
        
        // Return the modified image
        return image;
    }

    /**
     * Performs a depth-first search (DFS) to fill the image with the new color.
     * 
     * @param image         The input image represented as a 2D array of integers.
     * @param row           The current row index.
     * @param col           The current column index.
     * @param color         The new color to fill the image with.
     * @param originalColor The original color of the starting pixel.
     */
    public void dfsFloodFill(int[][] image, int row, int col, int color, int originalColor) {
        // Check if the current pixel is out of bounds or has a different color
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != originalColor) {
            return;
        }
        
        // Fill the current pixel with the new color
        image[row][col] = color;
        
        // Recursively call the dfsFloodFill method for the neighboring pixels
        dfsFloodFill(image, row, col + 1, color, originalColor);
        dfsFloodFill(image, row, col - 1, color, originalColor);
        dfsFloodFill(image, row + 1, col, color, originalColor);
        dfsFloodFill(image, row - 1, col, color, originalColor);
    }
}
