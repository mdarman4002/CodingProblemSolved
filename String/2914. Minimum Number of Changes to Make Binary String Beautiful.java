// 2914. Minimum Number of Changes to Make Binary String Beautiful
class Solution {
    
    /**
     * Calculates the minimum number of changes needed to make a binary string beautiful.
     * A binary string is considered beautiful if it does not contain any two adjacent characters
     * that are different.
     *
     * This method iterates through the input binary string and counts the number of adjacent
     * character pairs that are different. Each difference indicates a change needed to make
     * the characters the same.
     *
     * @param s The input binary string consisting of characters '0' and '1'.
     * @return The minimum number of changes required to make the binary string beautiful.
     *         Returns an integer representing the count of changes.
     *
     * Note: The method assumes that the input string is non-empty and contains only '0's and '1's.
     * It does not handle cases where the string is empty or contains invalid characters.
     */
    public int minChanges(String s) {
        int count = 0;
        int i = 0;
        int len = s.length();
        while(i < len){
            if(s.charAt(i++) != s.charAt(i)){
                count++;
            }
            i++;
        }
        return count;
    }
}
