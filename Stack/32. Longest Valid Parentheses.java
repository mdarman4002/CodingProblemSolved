/**
 * Solution class for finding the longest valid parentheses in a string.
 */
class Solution {
    /**
     * Finds the length of the longest valid parentheses in the input string.
     * 
     * @param s the input string to find the longest valid parentheses
     * @return the length of the longest valid parentheses
     */
    public int longestValidParentheses(String s) {
        // Create a stack to store indices of opening parentheses
        Stack<Integer> stack = new Stack<>();

      //  s =
// "()"
// so we are pushing -1 instead of 0
// Use Testcase
// Output
// 1
// Expected
// 2
        // Initialize the stack with -1 to handle edge cases
        stack.push(-1);
        
        // Initialize the longest valid parentheses length to 0
        int longest = 0;
        
        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If the current character is an opening parenthesis, push its index onto the stack
            if (ch == '(') {
                stack.push(i);
            } 
            // If the current character is a closing parenthesis
            else if (ch == ')') {
                // Pop the top of the stack (index of the matching opening parenthesis)
                stack.pop();
                
                // If the stack is empty, push the current index onto the stack
                if (stack.isEmpty()) {
                    stack.push(i);
                } 
                // Otherwise, update the longest valid parentheses length
                else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        
        // Return the length of the longest valid parentheses
        return longest;
    }
}
