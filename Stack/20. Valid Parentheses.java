/**
 * Solution class for validating brackets in a string.
 */
class Solution {
    /**
     * Validates whether the input string has valid brackets.
     * 
     * @param s the input string to validate
     * @return true if the brackets are valid, false otherwise
     */
    public boolean isValid(String s) {
        // Check for invalid input
        if (s == null || s.length() == 1 || s.length() % 2 != 0) {
            return false;
        }
        
        // Create a stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            // If the stack is empty, push the current character onto the stack
            if (stack.isEmpty()) {
                stack.push(ch);
            } 
            // If the top of the stack matches the current character, pop it
            else if (stack.peek() == '(' && ch == ')' || stack.peek() == '{' && ch == '}'
                    || stack.peek() == '[' && ch == ']') {
                stack.pop();
            } 
            // Otherwise, push the current character onto the stack
            else {
                stack.push(ch);
            }
        }
        
        // Return true if the stack is empty (i.e., all brackets are matched), false otherwise
        return stack.isEmpty();
    }
}


----------------------------------------------------------------


class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
