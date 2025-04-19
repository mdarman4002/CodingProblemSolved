class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }

        // Get the previous term
        String previousTerm = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();

        int count = 1; // To count occurrences of the current character
        char currentChar = previousTerm.charAt(0); // Start with the first character

        // Iterate through the previous term
        for (int i = 1; i < previousTerm.length(); i++) {
            if (previousTerm.charAt(i) == currentChar) {
                count++; // Increment count if the same character is found
            } else {
                // Append the count and the character to the result
                sb.append(count);
                sb.append(currentChar);
                currentChar = previousTerm.charAt(i); // Update to the new character
                count = 1; // Reset count for the new character
            }
        }

        // Append the last counted character
        sb.append(count);
        sb.append(currentChar);

        return sb.toString(); // Return the constructed string
    }
}

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String previous = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < previous.length(); ) {
            int count = 0;
            char curChar = previous.charAt(i);
            
            while (i < previous.length() && curChar == 
            previous.charAt(i)) {
                count++;
                i++;
                
            }
            result.append(count).append(curChar);

        }
        return result.toString();

    }
}
