class Solution {
    /**
     * Finds the longest common prefix between two integer arrays.
     * 
     * @param arr1 the first integer array
     * @param arr2 the second integer array
     * @return the length of the longest common prefix
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Create a HashSet to store the digits of arr2
        HashSet<Integer> set = new HashSet<>();

        // Iterate over each element in arr2 and add its digits to the set
        for (int curnum : arr2) {
            while (curnum > 0) {
                // Add the current digit to the set
                set.add(curnum);
                // Move to the next digit
                curnum = curnum / 10;
            }
        }

        // Initialize the maximum prefix length to 0
        int max = 0;

        // Iterate over each element in arr1
        for (int num : arr1) {
            while (num > 0) {
                // Check if the current digit is in the set
                if (set.contains(num)) {
                    // Update the maximum prefix length
                    max = Math.max(max, Integer.toString(num).length());
                }
                // Move to the next digit
                num /= 10;
            }
        }

        // Return the longest common prefix length
        return max;
    }
}

------------------------------------------------------------------------------

class Solution {
    /**
     * Finds the longest common prefix between two integer arrays.
     * 
     * @param arr1 the first integer array
     * @param arr2 the second integer array
     * @return the length of the longest common prefix
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Create a HashSet to store the digits of arr2
        HashSet<Integer> set = new HashSet<>();

        // Iterate over each element in arr2 and add its digits to the set
        for (int curnum : arr2) {
            while (curnum > 0) {
                // Add the current digit to the set
                set.add(curnum);
                // Move to the next digit
                curnum = curnum / 10;
            }
        }

        // Initialize the maximum prefix length to 0
        int max = 0;

        // Iterate over each element in arr1
        for (int i = 0; i < arr1.length; i++) {
            // Convert the current element to a string
            String cur = Integer.toString(arr1[i]);

            // Iterate over each prefix of the current string
            for (int j = 0; j < cur.length(); j++) {
                // Extract the current prefix
                String sub = cur.substring(0, j + 1);

                // Convert the prefix back to an integer
                int subint = Integer.parseInt(sub);

                // Check if the prefix is in the set
                if (set.contains(subint)) {
                    // Update the maximum prefix length
                    max = Math.max(max, sub.length());
                }
            }
        }

        // Return the longest common prefix length
        return max;
    }
}
