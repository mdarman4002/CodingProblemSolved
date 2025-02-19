/**
 * The Solution class provides a method to find the lexicographically smallest number
 * that satisfies a given pattern of increasing ('I') and decreasing ('D') relationships
 * between adjacent digits.
 */
class Solution {
    
    /**
     * Generates the smallest number that matches the given pattern of 'I' and 'D'.
     *
     * @param pattern A string consisting of characters 'I' (increasing) and 'D' (decreasing)
     *                that defines the relationships between adjacent digits.
     * @return A string representing the lexicographically smallest number that satisfies the pattern.
     */
    public String smallestNumber(String pattern) {
        int n = pattern.length(); // Length of the pattern
        boolean[] used = new boolean[10]; // Array to track used digits (1-9)
        StringBuilder result = new StringBuilder(); // StringBuilder to build the result
        backtrack(pattern, 0, new int[n + 1], used, result); // Start backtracking

        return result.toString(); // Return the resulting smallest number
    }

    /**
     * Backtracking method to find the smallest number that matches the pattern.
     *
     * @param pattern The pattern of 'I' and 'D' to satisfy.
     * @param index The current index in the pattern being processed.
     * @param num An array to hold the current digits being formed.
     * @param used An array to track which digits have been used.
     * @param result A StringBuilder to accumulate the result.
     * @return A boolean indicating whether a valid number has been found.
     */
    private boolean backtrack(String pattern, int index, int[] num, boolean[] used, StringBuilder result) {
        // Base case: if the index exceeds the pattern length
        if (index > pattern.length()) {
            for (int i = 0; i < num.length; i++) {
                result.append(num[i]); // Append the digits to the result
            }
            return true; // Found a valid lexicographically smallest number
        }

        // Try digits from 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            // Check if the digit is not used and if it satisfies the pattern condition
            if (!used[digit] && (index == 0 || isValid(num[index - 1], digit, pattern.charAt(index - 1)))) {
                used[digit] = true; // Mark the digit as used
                num[index] = digit; // Assign the digit to the current index
                // Recursively call backtrack for the next index
                if (backtrack(pattern, index + 1, num, used, result)) {
                    return true; // If a valid number is found, return true
                }
                num[index] = 0; // Backtrack: reset the current index
                used[digit] = false; // Mark the digit as unused
            }
        }
        return false; // Return false if no valid number is found
    }

    /**
     * Validates whether the current digit can be placed based on the last digit and the pattern condition.
     *
     * @param lastDigit The last digit placed in the number.
     * @param currentDigit The current digit being considered for placement.
     * @param condition The condition ('I' or 'D') that must be satisfied.
     * @return A boolean indicating whether the current digit placement is valid.
     */
    private boolean isValid(int lastDigit, int currentDigit, char condition) {
        return (condition == 'I' && lastDigit < currentDigit) || (condition == 'D' && lastDigit > currentDigit);
    }
}
