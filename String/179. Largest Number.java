/**
 * Solution class to find the largest number that can be formed by concatenating the given integers.
 */
class Solution {
    /**
     * Method to find the largest number that can be formed by concatenating the given integers.
     * 
     * @param nums an array of integers
     * @return the largest number that can be formed by concatenating the given integers
     */
    public String largestNumber(int[] nums) {
        // Convert the integer array to a string array
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }

        // Sort the string array in descending order based on the concatenated results
      // Arrays.sort(arr, (e1, e2) -> (e2 + e1).compareTo(e1 + e2));
          // Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        Arrays.sort(arr, new Comparator<String>() {
            /**
             * Compare two strings by concatenating them in both orders and comparing the results.
             * 
             * @param e1 the first string
             * @param e2 the second string
             * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
             */
            public int compare(String e1, String e2) {
                String s1 = e1 + e2;
                String s2 = e2 + e1;
                return s2.compareTo(s1);
            }
        });

        // Concatenate the sorted strings to form the largest number
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        // If the resulting string starts with "0", return "0" as the largest number
        if (sb.toString().startsWith("0")) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
