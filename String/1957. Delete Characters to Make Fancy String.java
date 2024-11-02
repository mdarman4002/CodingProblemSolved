class Solution {
    /**
     * This method takes a string as input and modifies it such that 
     * no character appears more than two consecutive times.
     * 
     * @param s The input string to be modified.
     * @return A new string with no character occurring more than twice in succession.
     */
    public String makeFancyString(String s) {
        // StringBuilder to build the resulting string efficiently
        StringBuilder ans = new StringBuilder();
        
        // Append the first character of the input string to the result
        ans.append(s.charAt(0));
        
        // Get the length of the input string
        int n = s.length();
        
        // Counter to keep track of consecutive characters
        int cnt = 1;
        
        // Iterate through the input string starting from the second character
        for (int i = 1; i < n; i++) {
            // Check if the current character is the same as the last character in the result
            if (s.charAt(i) == ans.charAt(ans.length() - 1)) {
                cnt++; // Increment the counter for consecutive characters
                
                // If the count of consecutive characters is less than 3, append the character to the result
                if (cnt < 3) {
                    ans.append(s.charAt(i));
                }
            } else {
                // If the current character is different, reset the counter and append the character to the result
                cnt = 1;
                ans.append(s.charAt(i));
            }
        }
        
        // Return the final modified string
        return ans.toString();
    }
}
