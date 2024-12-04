/**
 * The Solution class provides a method to determine if one string can be formed
 * as a subsequence of another string with specific rules regarding character transitions.
 */
class Solution {
    
    /**
     * Checks if str2 can be formed as a subsequence of str1.
     * 
     * A character in str1 can match:
     * 1. The same character in str2.
     * 2. The next character in the alphabet (e.g., 'a' can match 'b').
     * 3. The character 'z' can match 'a'.
     * 
     * @param str1 The source string from which we are forming the subsequence.
     * @param str2 The target string that we want to form as a subsequence.
     * @return true if str2 can be formed as a subsequence of str1, false otherwise.
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        int indexstr2 = 0; // Pointer for str2

        // Iterate through each character in str1
        for (int i = 0; i < str1.length(); i++) {
            // If we've matched all characters in str2, we can stop
            if (str2.length() == indexstr2) {
                break;
            }

            // Check if the current character in str1 is 'z' and the current character in str2 is 'a'
            if (str1.charAt(i) == 'z' && str2.charAt(indexstr2) == 'a') {
                indexstr2 += 1; // Move to the next character in str2
            }
            // Check if the current character in str1 matches the current character in str2
            else if (str1.charAt(i) == str2.charAt(indexstr2) || 
                     (char) (str1.charAt(i) + 1) == str2.charAt(indexstr2)) {
                indexstr2 += 1; // Move to the next character in str2
            }
        }

        // If we've matched all characters in str2, return true
        return indexstr2 == str2.length();
    }
}
