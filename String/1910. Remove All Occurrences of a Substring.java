/**
 * The {@code Solution} class provides a method to remove all occurrences of a specified substring
 * from a given string.
 */
class Solution {
    
    /**
     * Removes all occurrences of the specified substring from the given string.
     *
     * <p>
     * This method uses a {@link StringBuilder} to efficiently modify the string by removing
     * the specified substring whenever it is found. The search continues until no more occurrences
     * of the substring are found in the string.
     * </p>
     *
     * @param s    the original string from which the substring will be removed
     * @param part the substring that needs to be removed from the original string
     * @return a new string with all occurrences of the specified substring removed
     *         If the substring is not found, the original string is returned unchanged.
     */
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int m = part.length();
        while (true) {
            int substr = sb.indexOf(part);
            if (substr != -1) {
                sb.delete(substr, substr + m); 
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
