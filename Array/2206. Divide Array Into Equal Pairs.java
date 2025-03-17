/**
 * Class Solution
 * 
 * This class contains a method to determine if an integer array can be divided into pairs
 * such that each pair consists of equal elements.
 */
class Solution {
    
    /**
     * Determines if the given array can be divided into n pairs of equal elements.
     *
     * @param nums an integer array consisting of 2 * n integers.
     * @return true if the array can be divided into n pairs of equal elements, false otherwise.
     */
    public boolean divideArray(int[] nums) {
        // Create a count array to keep track of the frequency of each number
        int[] count = new int[500];
        
        // Count the occurrences of each number in the input array
        for(int ele : nums) {
            count[ele - 1]++;
        }
        
        // Check if each number appears an even number of times
        for(int i = 0; i < 500; i++) {
            if(count[i] % 2 != 0) {
                return false; // If any number appears an odd number of times, return false
            }
        }
        
        // If all numbers appear an even number of times, return true
        return true;
    }
}
