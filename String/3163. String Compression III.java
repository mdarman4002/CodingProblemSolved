/**
 * The Solution class provides a method to compress a string based on specific rules.
 */
class Solution {
    
    /**
     * Compresses the input string by counting consecutive characters.
     * 
     * The compression works as follows:
     * - For each character in the string, count how many times it appears consecutively.
     * - If the count exceeds 9, it will only count up to 9, and the remaining counts will be handled separately.
     * - Append the count followed by the character to the result string.
     * 
     * @param word The input string to be compressed.
     * @return The compressed version of the input string.
     */
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder(); // StringBuilder to build the compressed string
        int count = 1; // Initialize count of consecutive characters
        int n = word.length(); // Length of the input string

        // Edge case: If the string is empty, return an empty string
        if (n == 0) {
            return "";
        }

        char ch = word.charAt(0); // Start with the first character

        // Iterate through the string starting from the second character
        for (int i = 1; i < n; i++) {
            // If the current character is the same as the previous one and count is less than 9
            if (word.charAt(i) == ch && count < 9) {
                count++; // Increment the count
            } else {
                // Append the count and the character to the result
                comp.append(count).append(ch);
                ch = word.charAt(i); // Update the character to the current one
                count = 1; // Reset the count
            }
        }

        // Append the last counted character and its count
        comp.append(count).append(ch);
        
        return comp.toString(); // Return the compressed string
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "aaaaaaaaaaaaaabb"; // Example input
        String compressed = solution.compressedString(word);
        System.out.println(compressed); // Output: 9a5a2b
    }
}
