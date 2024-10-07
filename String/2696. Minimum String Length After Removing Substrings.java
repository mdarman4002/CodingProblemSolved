/**
 * This class provides a solution to the problem of finding the minimum length of a string
 * after removing all occurrences of "AB" and "CD" from the string.
 */
class Solution {
    /**
     * This method takes a string as input and returns the minimum length of the string
     * after removing all occurrences of "AB" and "CD".
     * 
     * @param s The input string
     * @return The minimum length of the string after removing all occurrences of "AB" and "CD"
     */
    public int minLength(String s) {
        /**
         * Create a StringBuilder object from the input string to allow for efficient
         * modification of the string.
         */
        StringBuilder sb = new StringBuilder(s);

        /**
         * Initialize a variable to keep track of the current index in the string.
         */
        int i = 0;

        /**
         * Loop through the string until we have processed all characters.
         */
        while (i < sb.length() - 1) {
            /**
             * Check if the current character and the next character form either "AB" or "CD".
             * If they do, remove them from the string and decrement the index to account for
             * the removal.
             */
            if ((i + 2 <= sb.length() && sb.substring(i, i + 2).equals("AB"))
                    || (i + 2 <= sb.length() && sb.substring(i, i + 2).equals("CD"))) {
                sb.delete(i, i + 2);
                i--;
                i = Math.max(0, i);
            } else {
                /**
                 * If the current character and the next character do not form "AB" or "CD",
                 * increment the index to move to the next character.
                 */
                i++;
            }
        }

        /**
         * Return the length of the modified string, which represents the minimum length
         * after removing all occurrences of "AB" and "CD".
         */
        return sb.length();
    }
}
