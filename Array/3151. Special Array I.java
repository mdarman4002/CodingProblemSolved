/**
 * This class provides a solution to determine if an array of integers is "special".
 */
class Solution {
    
    /**
     * Checks if the given array of integers is "special".
     * An array is considered special if no two adjacent elements have the same parity.
     * In other words, the elements must alternate between even and odd.
     *
     * @param nums an array of integers to be checked
     * @return true if the array is special (alternating even and odd), false otherwise
     */
    public boolean isArraySpecial(int[] nums) {
        // If the array has only one element, it is considered special
        if(nums.length == 1){
            return true;
        }
        
        // Iterate through the array to check the parity of adjacent elements
        for(int i = 0; i < nums.length - 1; i++){
            int cur = nums[i] % 2; // Get the parity of the current element
            int next = nums[i + 1] % 2; // Get the parity of the next element
            
            // If both current and next elements have the same parity, return false
            if((cur == 1 && next == 1) || (cur == 0 && next == 0)){
                return false;
            }
        }
        
        // If no adjacent elements have the same parity, return true
        return true;
    }
}
