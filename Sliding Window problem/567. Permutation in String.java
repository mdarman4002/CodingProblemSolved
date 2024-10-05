/**
 * Solution to the "Permutation in String" problem on LeetCode.
 */
class Solution {
    /**
     * Checks if a permutation of string `s1` exists in string `s2`.
     * 
     * @param s1 the string to find a permutation of
     * @param s2 the string to search in
     * @return true if a permutation of `s1` exists in `s2`, false otherwise
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        /**
         * Count arrays to keep track of characters in `s1` and the current window of `s2`.
         */
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        /**
         * Initialize the count arrays.
         */
        for (int i = 0; i < s1.length(); i++) {
            int index1 = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            map1[index1]++;
            map2[index2]++;
        }

        /**
         * Check if the initial window matches.
         */
        if (isFound(map1, map2)) return true;

        /**
         * Slide the window over `s2`.
         */
        for (int i = s1.length(); i < s2.length(); i++) {
            /**
             * Remove the leftmost character from the window.
             */
            map2[s2.charAt(i - s1.length()) - 'a']--;

            /**
             * Add the new character to the window.
             */
            map2[s2.charAt(i) - 'a']++;

            /**
             * Check if the current window matches.
             */
            if (isFound(map1, map2)) return true;
        }

        return false;
    }

    /**
     * Checks if two count arrays are equal.
     * 
     * @param map1 the first count array
     * @param map2 the second count array
     * @return true if the two arrays are equal, false otherwise
     */
    public boolean isFound(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
