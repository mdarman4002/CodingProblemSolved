/**
 * Solution class for finding the minimum extra characters needed to form a string from a given dictionary.
 */
class Solution {
    /**
     * Dynamic programming array to store the minimum extra characters for each substring.
     */
    int dp[] = new int[50];

    /**
     * Main method to find the minimum extra characters needed to form the input string from the given dictionary.
     * 
     * @param s      the input string
     * @param dictionary  the array of dictionary words
     * @return the minimum extra characters needed
     */
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Arrays.fill(dp, -1); // initialize dp array with -1
        HashSet<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        return recur(s, dictionarySet, 0);
    }

    /**
     * Recursive method to find the minimum extra characters needed to form the substring from the given dictionary.
     * 
     * @param s      the input string
     * @param dictionary  the set of dictionary words
     * @param index  the current index in the string
     * @return the minimum extra characters needed
     */
    public int recur(String s, HashSet<String> dictionary, int index) {
        /**
         * Base case: if the index reaches the end of the string, return 0 (no extra characters needed)
         */
        if (index == s.length()) {
            return 0;
        }

        /**
         * If the result is already computed, return the cached value
         */
        if (dp[index] != -1) {
            return dp[index];
        }

        StringBuilder sb = new StringBuilder();
        int minExtraChar = Integer.MAX_VALUE;

        /**
         * Iterate through the string, building substrings and checking if they are in the dictionary
         */
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i)); // build the substring
            int extraChar = 0;
            if (!dictionary.contains(sb.toString())) {
                extraChar = sb.length(); // calculate extra characters if not in dictionary
            }
            int curExtra = recur(s, dictionary, i + 1); // recursive call for the remaining substring
            minExtraChar = Math.min(minExtraChar, extraChar + curExtra);
        }

        /**
         * Cache the result and return it
         */
        return dp[index] = minExtraChar;
    }
}
