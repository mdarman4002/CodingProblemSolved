import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Solution class provides a method to merge two 2D integer arrays
 * containing unique IDs and their associated values.
 */
class Solution {
    
    /**
     * Merges two 2D integer arrays into a single 2D array sorted by ID.
     * 
     * Each input array contains pairs of integers where the first integer
     * represents an ID and the second integer represents a value. The method
     * sums the values of IDs that appear in both arrays and includes each ID
     * only once in the resulting array.
     * 
     * @param nums1 A 2D integer array where each element is an array of two integers
     *               representing an ID and its associated value.
     * @param nums2 A 2D integer array where each element is an array of two integers
     *               representing an ID and its associated value.
     * @return A 2D integer array containing unique IDs and their summed values,
     *         sorted in ascending order by ID.
     * 
     * Example:
     * 
     * Input:
     * nums1 = [[1, 2], [2, 3]]
     * nums2 = [[2, 1], [3, 4]]
     * 
     * Output:
     * [[1, 2], [2, 4], [3, 4]]
     * 
     * Note: The resulting array is sorted by ID, and the values for ID 2 are summed
     * (3 from nums1 and 1 from nums2).
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Populate the map with values from nums1
        for (int[] nums : nums1) {
            map.put(nums[0], map.getOrDefault(nums[0], 0) + nums[1]);
        }
        
        // Populate the map with values from nums2
        for (int j = 0; j < nums2.length; j++) {
            int key = nums2[j][0];
            int value = nums2[j][1];
            map.put(key, map.getOrDefault(key, 0) + value);
        }
        
        // Create a list of entries and sort them by key
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        int row = map.size();
        int col = 2;
        int[][] Array2D = new int[row][col];

        // Fill the Array2D with sorted entries
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<Integer, Integer> entry = entryList.get(i);
            Array2D[i][0] = entry.getKey();   // Set the key (ID)
            Array2D[i][1] = entry.getValue(); // Set the value (summed value)
        }
        
        return Array2D;
    }
}
