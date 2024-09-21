/**
 * Solution class for generating the largest possible number from an array of integers.
 */
class Solution {
    /**
     * Generates the largest possible number from an array of integers.
     * 
     * @param nums The input array of integers.
     * @return The largest possible number as a string.
     */
    public String largestNumber(int[] nums) {
        // Convert the input array of integers to an array of strings
        String[] arr = new String[nums.length];
        
        // Convert each integer to a string and store it in the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        
        // Sort the array of strings in descending order based on a custom comparator
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String e1, String e2) {
                // Compare the concatenation of the two strings in both orders
                String s1 = e1 + e2;
                String s2 = e2 + e1;
                // Return the comparison result in descending order
                return s2.compareTo(s1);
            }
        });
        
        // Build the largest possible number by concatenating the sorted strings
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        // Handle the case where the largest possible number is 0
        if (sb.toString().startsWith("0")) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
