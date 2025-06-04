class Solution {

    // Main function to start partitioning the string
    public List<List<String>> partition(String s) {
        List<List<String>> allPartitions = new ArrayList<>(); // Final result list
        List<String> currentPartition = new ArrayList<>();    // Stores current valid palindromic partition
        findPartitions(s, 0, allPartitions, currentPartition);
        return allPartitions;
    }

    // Recursive backtracking function to find all palindromic partitions
    private void findPartitions(String s, int startIndex, List<List<String>> result, List<String> current) {
        // Base case: if we've reached the end of the string, add current partition to result
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting from 'startIndex'
        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            // Check if the substring s[startIndex...endIndex] is a palindrome
            if (isPalindrome(s, startIndex, endIndex)) {
                // If it is, add it to the current partition
                current.add(s.substring(startIndex, endIndex + 1));

                // Recurse for the remaining substring
                findPartitions(s, endIndex + 1, result, current);

                // Backtrack: remove the last added substring to explore other possibilities
                current.remove(current.size() - 1);
            }
        }
    }

    // Helper function to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
