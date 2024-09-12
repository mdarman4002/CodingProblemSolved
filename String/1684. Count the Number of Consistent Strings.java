/**
 * Class Solution contains a method to count the number of consistent strings in a given array of words.
 */
class Solution {
    /**
     * Counts the number of consistent strings in the given array of words.
     * 
     * A consistent string is a string that only contains characters present in the allowed string.
     * 
     * @param allowed the string containing the allowed characters
     * @param words the array of words to check for consistency
     * @return the count of consistent strings
     */
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a HashSet to store the allowed characters for efficient lookup
        HashSet<Character> setAllow = new HashSet<>();
        
        // Populate the HashSet with the allowed characters
        for (int i = 0; i < allowed.length(); i++) {
            char ch = allowed.charAt(i);
            setAllow.add(ch);
        }
        
        // Initialize a counter for the consistent strings
        int count = 0;
        
        // Iterate over each word in the array
        for (int i = 0; i < words.length; i++) {
            // Initialize a flag to indicate if the word is consistent
            boolean flag = true;
            
            // Get the current word
            String word = words[i];
            
            // Iterate over each character in the word
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                
                // If the character is not in the allowed set, mark the word as inconsistent
                if (!setAllow.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            
            // If the word is consistent, increment the count
            if (flag) {
                count += 1;
            }
        }
        
        // Return the count of consistent strings
        return count;
    }
}
