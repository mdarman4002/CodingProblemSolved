/**
 * The Solution class provides a method to apply operations on an array of integers.
 */
class Solution {
    
    /**
     * Applies operations on the given array of integers. The operation consists of merging
     * adjacent equal elements by doubling the first element and setting the second element to zero.
     * After applying the operations, the method rearranges the array such that all non-zero
     * elements are moved to the front, and all zeros are moved to the back.
     *
     * @param nums an array of integers where operations will be applied
     * @return an array of integers with the operations applied and zeros moved to the end
     */
    public int[] applyOperations(int[] nums) {
        
        // Iterate through the array to apply the merging operation
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2; // Double the current element
                nums[i + 1] = 0;       // Set the next element to zero
            }
        }
        
        // Create a new array to store the result
        int[] arr = new int[nums.length];
        int endIndex = arr.length - 1; // Pointer for the end of the result array
        int startIndex = 0;             // Pointer for the start of the result array
        
        // Rearrange the elements: non-zero elements to the front, zeros to the back
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                arr[endIndex--] = 0; // Place zero at the end
            } else {
                arr[startIndex++] = nums[i]; // Place non-zero element at the start
            }
        }
        
        return arr; // Return the rearranged array
    }
}
