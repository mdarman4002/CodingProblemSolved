/**
 * The Solution class provides a method to generate the k-th "happy string" of length n.
 * A "happy string" is defined as a string that does not contain three consecutive identical characters.
 * The characters used to form the happy strings are limited to 'a', 'b', and 'c'.
 */
class Solution {
    int count; // Counter to track the number of happy strings generated
    String res; // Result string to store the k-th happy string

    /**
     * Generates the k-th happy string of length n.
     *
     * @param n The length of the happy string to be generated.
     * @param k The index (1-based) of the happy string to return.
     * @return The k-th happy string of length n, or an empty string if k is out of bounds.
     */
    public String getHappyString(int n, int k) {
        count = 0; // Initialize the count of happy strings
        res = ""; // Initialize the result string
        backtrack(n, k, new StringBuilder()); // Start the backtracking process
        return res; // Return the k-th happy string found
    }

    /**
     * Backtracking method to generate happy strings.
     *
     * @param n The target length of the happy string.
     * @param k The index of the happy string to find.
     * @param cur The current string being built.
     * @return A boolean indicating whether the k-th happy string has been found.
     */
    public boolean backtrack(int n, int k, StringBuilder cur) {
        // Base case: if the current string has reached the target length
        if (cur.length() == n) {
            count++; // Increment the count of happy strings generated
            if (count == k) { // Check if the k-th happy string has been found
                res = cur.toString(); // Store the result
                return true; // Indicate that the k-th string has been found
            }
            return false; // Continue searching for the k-th string
        }

        // Iterate through characters 'a', 'b', and 'c'
        for (char ch = 'a'; ch <= 'c'; ch++) {
            int len = cur.length();
            // Skip if the last character is the same as the current character
            if (len > 0 && cur.charAt(len - 1) == ch) {
                continue; // Avoid consecutive identical characters
            }
            cur.append(ch); // Add the current character to the string
            // Recursively call backtrack to continue building the string
            if (backtrack(n, k, cur))
                return true; // If the k-th string is found, return true
            
            cur.deleteCharAt(cur.length() - 1); // Backtrack: remove the last character
        }
        return false; // Return false if the k-th string is not found
    }
}
