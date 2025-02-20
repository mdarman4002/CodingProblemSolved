/**
 * The Solution class provides a method to find a binary string that is not present in the given list of binary strings.
 */
class Solution {
    
    /**
     * Finds a binary string of the same length as the input strings that is not present in the input array.
     * 
     * This method uses a diagonalization approach to construct a binary string that differs from each 
     * binary string in the input array at the corresponding index. For example, if the input contains 
     * "01" and "10", the method will return "00" because it differs from "01" at index 0 and from "10" 
     * at index 1.
     *
     * @param nums An array of binary strings of equal length. Each string consists of '0's and '1's.
     * @return A binary string that is not present in the input array.
     */
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        
        // Construct the result string by flipping the bits at each index
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        
        return ans.toString();
    }
}

-----------------------------------------------------------------------------------------------------------------------------
  /**
 * The Solution class provides a method to find a binary string that is not present in the given list of binary strings.
 */
class Solution {
    
    /**
     * Finds a binary string of the same length as the input strings that is not present in the input array.
     * 
     * This method uses a boolean array to track which binary strings are present and then finds the first
     * missing binary string by checking the boolean array.
     *
     * @param nums An array of binary strings of equal length. Each string consists of '0's and '1's.
     * @return A binary string that is not present in the input array, formatted to the same length as the input strings.
     */
    public String findDifferentBinaryString(String[] nums) {
        int max = nums.length; // Length of the input array
        boolean[] array = new boolean[(int) Math.pow(2, max)]; // Boolean array to track present binary strings
        
        // Mark the existing binary strings in the boolean array
        for (String bin : nums) {
            int binInt = Integer.parseInt(bin, 2); // Convert binary string to integer
            array[binInt] = true; // Mark this binary string as present
        }
        
        // Find the first false index in the boolean array
        int res = 0;
        for (int i = 0; i < (int) Math.pow(2, max); i++) {
            if (!array[i]) { // If this index is not marked, it's the missing binary string
                res = i;
                break;
            }
        }
        
        // Convert the result to a binary string and format it to the correct length
        String binaryString = Integer.toBinaryString(res); 
        return String.format("%" + max + "s", binaryString).replace(' ', '0'); // Pad with leading zeros
    }
}
