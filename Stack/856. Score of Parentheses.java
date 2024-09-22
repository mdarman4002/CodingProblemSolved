class Solution {
    
    // This method calculates the score of a valid parentheses string using a stack.
    public int scoreOfParentheses(String s) {
        // Stack to store intermediate values and markers.
        Stack<Integer> stack = new Stack<>();

        // Iterate over each character in the string.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // Get the current character.

            if (ch == '(') {
                // Push -1 as a marker for an open parenthesis '('
                stack.push(-1);
            } else {
                // If the character is a closing parenthesis ')'
                if (stack.peek() == -1) {
                    // If top of stack is -1, it means we found a pair "()".
                    stack.pop(); // Remove the marker (-1)
                    stack.push(1); // Push 1, the score for "()"
                } else {
                    // If it's not a pair, we have a nested structure like "(A)"
                    // Calculate the score for the inner structure A
                    int curVal = 0;
                    while (stack.peek() != -1) {
                        curVal += stack.pop(); // Add up all values inside this level of parentheses.
                    }
                    stack.pop(); // Remove the open parenthesis marker (-1)
                    // Push 2 * curVal, the score for a nested structure "(A)"
                    stack.push(2 * curVal);
                }
            }
        }

        // At this point, the stack contains the final scores.
        int output = 0;
        // Sum all values in the stack to get the total score.
        while (stack.size() > 0) {
            output += stack.pop();
        }

        return output;
    }
}
