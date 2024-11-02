class Solution {
    /**
     * This method checks if a given sentence is a circular sentence.
     * A circular sentence is defined as one where:
     * - The last character of each word matches the first character of the next word.
     * - The last character of the last word matches the first character of the first word.
     *
     * @param sentence The input sentence to be checked.
     * @return true if the sentence is circular, false otherwise.
     */
    public boolean isCircularSentence(String sentence) {
        // Split the input sentence into words using space as a delimiter
        String[] arr = sentence.split(" ");
        
        // Initialize a boolean result variable
        boolean res = true;
        
        // Check for the case where there is only one word
        if (arr.length == 1) {
            String str = arr[0];
            // If the first and last characters of the single word match, return true
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                return true;
            } else {
                return false; // Return false if they do not match
            }
        }
        
        // Iterate through the array of words, checking adjacent pairs
        for (int i = 0; i < arr.length - 1; i++) {
            String str1 = arr[i]; // Current word
            String str2 = arr[i + 1]; // Next word
            
            // Check if the last character of the current word matches the first character of the next word
            if (str1.charAt(str1.length() - 1) != str2.charAt(0)) {
                res = false; // Set result to false if they do not match
                return res; // Return immediately as we found a mismatch
            }
        }
        
        // Check if the first character of the first word matches the last character of the last word
        String first = arr[0]; // First word
        String last = arr[arr.length - 1]; // Last word
        
        // If they do not match, set result to false
        if (first.charAt(0) != last.charAt(last.length() - 1)) {
            res = false;
        }
        
        // Return the final result
        return res;
    }
}
