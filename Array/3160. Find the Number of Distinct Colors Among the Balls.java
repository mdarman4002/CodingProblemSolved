import java.util.HashMap;

/**
 * The Solution class provides a method to process a series of queries related to balls of different colors.
 */
class Solution {
    
    /**
     * Processes a series of queries to determine the number of distinct colors present after each query.
     *
     * Each query consists of a ball identifier and a color. If the ball already has a color, it is updated to the new color.
     * The method keeps track of the number of distinct colors after each query.
     *
     * @param limit The maximum number of queries to process. This parameter is not used in the current implementation.
     * @param queries A 2D array where each element is an array of two integers:
     *                - The first integer represents the ball identifier.
     *                - The second integer represents the color assigned to the ball.
     * @return An array of integers where each element represents the number of distinct colors present after each query.
     */
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorMap = new HashMap<>(); // Maps color to its count
        HashMap<Integer, Integer> ballMap = new HashMap<>();  // Maps ball to its current color
        int result[] = new int[queries.length]; // Array to store the result for each query
        
        // Iterate through each query
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];   // Get the ball identifier
            int color = queries[i][1];   // Get the color to assign
            
            // Check if the ball already has a color
            if (ballMap.containsKey(ball)) {
                int oldColor = ballMap.get(ball); // Get the old color of the ball
                // Decrement the count of the old color
                colorMap.put(oldColor, colorMap.get(oldColor) - 1);
                
                // Remove the old color from the map if its count reaches zero
                if (colorMap.get(oldColor) == 0) {
                    colorMap.remove(oldColor);
                }
            }
            
            // Update the ball's color to the new color
            ballMap.put(ball, color);
            // Increment the count of the new color
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            // Store the number of distinct colors in the result array
            result[i] = colorMap.size();
        }
        
        return result; // Return the result array
    }
}
