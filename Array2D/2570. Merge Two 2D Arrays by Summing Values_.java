import java.util.ArrayList;

/**
 * The Solution class provides a method to merge two sorted 2D integer arrays
 * containing unique IDs and their associated values.
 */
class Solution {
    
    /**
     * Merges two sorted 2D integer arrays into a single sorted 2D array.
     * 
     * Each input array contains pairs of integers where the first integer
     * represents an ID and the second integer represents a value. The method
     * sums the values of IDs that appear in both arrays and includes each ID
     * only once in the resulting array.
     * 
     * @param nums1 A 2D integer array where each element is an array of two integers
     *               representing an ID and its associated value. The array is sorted
     *               in ascending order by ID.
     * @param nums2 A 2D integer array where each element is an array of two integers
     *               representing an ID and its associated value. The array is sorted
     *               in ascending order by ID.
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
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        ArrayList<int[]> list = new ArrayList<>();
        
        // Merge the two arrays
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                // If IDs are the same, sum their values
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                // If ID in nums1 is smaller, add it to the result
                list.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else {
                // If ID in nums2 is smaller, add it to the result
                list.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }
        
        // Add remaining elements from nums1
        while (i < n) {
            list.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        
        // Add remaining elements from nums2
        while (j < m) {
            list.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }
        
        // Convert the list to a 2D array
        int row = list.size();
        int col = 2;
        int[][] resultArray2D = new int[row][col];
        for (int index = 0; index < row; index++) {
            resultArray2D[index] = list.get(index);
        }
        
        return resultArray2D;
    }
}
