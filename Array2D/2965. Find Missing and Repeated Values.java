import java.util.HashMap;

/**
 * The Solution class provides a method to find the missing and repeated values
 * in a 2D grid of integers where the integers range from 1 to n*n.
 */
class Solution {
    
    /**
     * Finds the missing and repeated values in a given n x n grid.
     *
     * @param grid A 2D array of integers where each integer is in the range [1, n*n].
     *             The grid contains one repeated number and one missing number.
     * @return An array of two integers where:
     *         - The first element is the repeated number.
     *         - The second element is the missing number.
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ans[] = new int[2]; // Array to store the result: [repeated, missing]
        int n = grid.length; // Get the size of the grid (n x n)
        int totalNum = n * n; // Total numbers expected in the grid
        int totalSum = (totalNum * (totalNum + 1)) / 2; // Sum of first n*n natural numbers
        HashMap<Integer, Integer> map = new HashMap<>(); // Map to track occurrences of numbers
        
        // Iterate through each row of the grid
        for (int[] arr : grid) {
            // Iterate through each element in the current row
            for (int i = 0; i < arr.length; i++) {
                // Check if the number has already been seen (repeated)
                if (map.containsKey(arr[i])) {
                    ans[0] = arr[i]; // Store the repeated number
                } else {
                    // If it's the first time seeing the number, add it to the map
                    map.put(arr[i], i);
                    totalSum -= arr[i]; // Subtract the current number from totalSum
                }
            }
        }
        
        // The missing number is the totalSum after processing the grid
        ans[1] = totalSum;
        return ans; // Return the result array
    }
}


--------------------------------100%  using array -----------------------------------
  
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ans[] = new int[2];
        int n = grid.length;
        int totalNum = n * n;
        int totalSum = (totalNum * ( totalNum + 1)) / 2;
        //HashMap<Integer,Integer> map = new HashMap<>();
        int set[] = new int[totalNum + 1];
        for(int[] arr: grid){
            for(int i = 0; i < arr.length; i++){
                if(set[arr[i]] != 0){
                    ans[0] = arr[i];
                    
                }
                else{
                    //map.put(arr[i],i);
                    set[arr[i]] = 1;
                    totalSum -= arr[i];
                }
            }
        }
        ans[1] = totalSum;
        return ans;
    }
}
