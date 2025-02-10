/**
 * The {@code Solution} class provides a method to process a string by removing digits
 * and retaining only lowercase letters. If a digit is encountered, the last appended
 * lowercase letter is removed from the result.
 */
class Solution {

    /**
     * Removes digits from the input string and retains only lowercase letters.
     * If a digit is encountered, the last appended lowercase letter is removed.
     *
     * <p>
     * For example, given the input string "abc123def", the output will be "abcdef".
     * If the input string is "abc1d2e3", the output will be "abde".
     * </p>
     *
     * @param s the input string to be processed
     * @return a new string containing only lowercase letters, with digits causing
     *         the removal of the last appended lowercase letter
     */
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
              //ch >= 'a' && ch <= 'z' // 26
              //Character.isLetter(ch)  it will take more time because it will check ch >= 'a' ch <= 'a' and ch >= 'A' ch <= 'A' // 52
                sb.append(ch);
            } else if (Character.isDigit(ch)) {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
}
