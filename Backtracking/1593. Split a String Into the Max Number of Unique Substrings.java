import java.util.HashSet;

class Solution {
    // Variable to keep track of the maximum number of unique substrings found
    int max;

    /**
     * This method initiates the process of finding the maximum number of unique splits
     * in the given string.
     *
     * @param s The input string to be split into unique substrings.
     * @return The maximum number of unique substrings that can be formed.
     */
    public int maxUniqueSplit(String s) {
        max = 0; // Initialize max to zero
        HashSet<String> set = new HashSet<>(); // Create a set to store unique substrings
        findUnique(s, set, 0); // Start the recursive search for unique splits
        return max; // Return the maximum count of unique substrings found
    }

    /**
     * This recursive method explores all possible unique splits of the string.
     *
     * @param s The original string to be split.
     * @param set A HashSet that keeps track of unique substrings found so far.
     * @param index The current index in the string from which to generate substrings.
     */
    public void findUnique(String s, HashSet<String> set, int index) {
        int len = s.length(); // Get the length of the string

        // Base case: If the index reaches the length of the string, check the size of the set
        if (index == len) {
            max = Math.max(max, set.size()); // Update max if the current size is larger
            return; // Exit the recursion
        }

        // Iterate through the string to create substrings
        for (int i = index; i < len; i++) {
            String substring = s.substring(index, i + 1); // Create a substring from index to i

            // Only proceed if the substring is not already in the set
            if (!set.contains(substring)) {
                set.add(substring); // Add the substring to the set
                findUnique(s, set, i + 1); // Recursively call to explore further splits
                set.remove(substring); // Backtrack: remove the substring for the next iteration
            }
        }
    }
}
