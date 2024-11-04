/**
 * The Solution class provides a method to compress a character array based on specific rules.
 */
class Solution {
    
    /**
     * Compresses the input character array by counting consecutive characters.
     * 
     * The compression works as follows:
     * - For each character in the array, count how many times it appears consecutively.
     * - If the count is greater than 1, append the count after the character.
     * - The compressed characters are written back into the input array.
     * 
     * @param chars The input character array to be compressed. The array is modified in place.
     * @return The new length of the compressed character array.
     */
    public int compress(char[] chars) {
        int count = 1; // Initialize count of consecutive characters
        StringBuilder sb = new StringBuilder(); // StringBuilder to build the compressed string

        // Append the first character to the StringBuilder
        sb.append(chars[0]);

        // Iterate through the character array starting from the second character
        for (int i = 1; i < chars.length; i++) {
            // If the current character is different from the previous one
            if (chars[i - 1] != chars[i]) {
                // If count is greater than 1, append the count to the StringBuilder
                if (count > 1) {
                    sb.append(count);
                }
                // Append the current character to the StringBuilder
                sb.append(chars[i]);
                count = 1; // Reset the count for the new character
            } else {
                count++; // Increment the count for the current character
            }
        }

        // Append the count for the last character if it appears more than once
        if (count > 1) {
            sb.append(count);
        }

        // Write the compressed characters back into the input array
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            chars[i] = ch; // Update the input array with compressed characters
        }

        return sb.length(); // Return the new length of the compressed character array
    }
}
