/**
 * This class provides a solution to the minimum steps problem.
 */
class Solution {
    /**
     * This method calculates the minimum number of steps required to make all characters in the string 's' equal.
     * 
     * @param s The input string
     * @return The minimum number of steps required
     */
    public long minimumSteps(String s) {
        /**
         * Initialize two pointers, l and r, to 1. These pointers will be used to keep track of the number of '1's and '0's encountered so far.
         */
        long l = 1;
        long r = 1;
        
        /**
         * Initialize the result variable to 0. This variable will store the minimum number of steps required.
         */
        long res = 0;
        
        /**
         * Iterate through the input string 's' character by character.
         */
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            /**
             * If the current character is '1', increment the right pointer 'r'.
             */
            if(ch == '1'){
                r++;
            } else {
                /**
                 * If the current character is '0', increment the result by the difference between the right pointer 'r' and the left pointer 'l', 
                 * and then increment both 'r' and 'l' by 1.
                 */
                res += (r - l);
                r++;
                l++;
            }
        }
        
        /**
         * Return the minimum number of steps required.
         */
        return res;
    }
}
