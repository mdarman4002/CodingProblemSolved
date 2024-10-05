/**
 * Solution class for finding the length of the longest substring without repeating characters.
 */
class Solution {
    /**
     * Returns the length of the longest substring without repeating characters in the given string.
     * 
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        /**
         * A hashmap to store the characters and their corresponding indices.
         */
        HashMap<Character, Integer> map = new HashMap<>();
        
        /**
         * The maximum length of the substring without repeating characters found so far.
         */
        int max = 0;
        
        /**
         * The current maximum length of the substring without repeating characters.
         */
        int curmax = 0;
        
        /**
         * The left boundary of the sliding window.
         */
        int left = 0;
        
        /**
         * Iterate through the characters in the input string.
         */
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            /**
             * If the character is already in the hashmap, update the left boundary of the sliding window.
             */
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            
            /**
             * Update the hashmap with the current character and its index.
             */
            map.put(ch, i);
            
            /**
             * Calculate the current maximum length of the substring without repeating characters.
             */
            curmax = i - left + 1;
            
            /**
             * Update the maximum length of the substring without repeating characters found so far.
             */
            max = Math.max(max, curmax);
        }
        
        /**
         * Return the maximum length of the substring without repeating characters.
         */
        return max;
    }
}
