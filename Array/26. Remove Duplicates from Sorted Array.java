/**
 * Solution class for removing duplicates from a sorted array.
 */
class Solution {

    /**
     * Removes duplicates from a sorted array in-place and returns the length of the resulting array.
     * 
     * @param nums the input sorted array
     * @return the length of the array after removing duplicates
     */
    public int removeDuplicates(int[] nums) {
        
        // Initialize a counter to keep track of the number of unique elements
        int uniqueCount = 0;
      
        // Iterate through each element in the input array
        for (int currentNum : nums) {
           
            // Check if the current element is different from the previous one (or if it's the first element)
            if (uniqueCount == 0 || currentNum != nums[uniqueCount - 1]) {
              
                // If it's different, add it to the result array and increment the unique count
                nums[uniqueCount++] = currentNum;
            }
        }
      
        // Return the length of the resulting array (i.e., the number of unique elements)
        return uniqueCount;
    }
}
