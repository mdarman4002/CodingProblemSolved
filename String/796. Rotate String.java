/**
 * Solution class for determining if one string is a rotation of another.
 */
class Solution {
    
    /**
     * Checks if the string `goal` can be obtained by rotating the string `s`.
     *
     * A string `goal` is considered a rotation of string `s` if it can be obtained 
     * by moving the characters from the front of `s` to the back without changing 
     * their order. For example, "abcde" can be rotated to "deabc", "eabcd", etc.
     *
     * @param s the original string to be rotated
     * @param goal the target string to check against
     * @return true if `goal` is a rotation of `s`, false otherwise
     * 
     * @throws IllegalArgumentException if either `s` or `goal` is null
     */
    public boolean rotateString(String s, String goal) {
        // Check for null inputs
        if (s == null || goal == null) {
            throw new IllegalArgumentException("Input strings cannot be null.");
        }
        
        // Check if the lengths are different
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate the string with itself
        String concat = s + s;
        // return concat.contains(goal);
        // Check for each possible starting index in concat
        for (int i = 0; i < s.length(); i++) {
            boolean match = true;
            for (int j = 0; j < goal.length(); j++) {
                // Compare characters
                if (goal.charAt(j) != concat.charAt(i + j)) {
                    match = false;
                    break;
                }
            }
            // Return true if a match is found
            if (match) {
                return true;
            }
        }
        // Return false if no match is found
        return false;
    }
}
