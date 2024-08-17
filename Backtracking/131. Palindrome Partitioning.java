131. Palindrome Partitioning

/**
 * Solution class for partitioning a string into palindromic substrings.
 */
class Solution {
    /**
     * Partition the input string into palindromic substrings.
     * 
     * @param s The input string to be partitioned.
     * @return A list of lists, where each inner list represents a partition of the input string into palindromic substrings.
     */
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        findPartition(s, 0, len, result, current);
        return result;
    }

    /**
     * Recursive helper method to find all possible partitions of the input string into palindromic substrings.
     * 
     * @param s The input string to be partitioned.
     * @param index The current index in the input string.
     * @param len The length of the input string.
     * @param result The list of lists to store the partitions.
     * @param current The current partition being constructed.
     */
    public void findPartition(String s, int index, int len, List<List<String>> result, ArrayList<String> current) {
        // Base case: if the current index reaches the end of the string, add the current partition to the result
        if (index == len) {
            result.add(new ArrayList<String>(current));
        }
        // Iterate over the remaining characters in the string
        for (int i = index; i < len; i++) {
            // Check if the substring from the current index to i is a palindrome
            if (isPalindrome(s, index, i)) {
                // Add the palindromic substring to the current partition
                current.add(s.substring(index, i + 1));
                // Recursively find partitions for the remaining substring
                findPartition(s, i + 1, len, result, current);
                // Backtrack by removing the last added substring from the current partition
                current.remove(current.size() - 1);
            }
        }
    }

    /**
     * Check if a substring of the input string is a palindrome.
     * 
     * @param s The input string.
     * @param startIndex The starting index of the substring.
     * @param endIndex The ending index of the substring.
     * @return True if the substring is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
