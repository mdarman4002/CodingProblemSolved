class Solution {
    /**
     * Evaluates a boolean expression represented as a string.
     *
     * The expression can include boolean literals ('t' for true, 'f' for false),
     * operators ('&' for AND, '|' for OR, '!' for NOT), and parentheses for grouping.
     *
     * @param expression A string representing the boolean expression to evaluate.
     * @return boolean Returns true if the evaluated expression results in true ('t'),
     *                 otherwise returns false ('f').
     */
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>(); // Stack to hold characters
        int n = expression.length(); // Length of the expression

        // Iterate through each character in the expression
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == ')') { // When encountering a closing parenthesis
                ArrayList<Character> list = new ArrayList<>(); // List to hold the enclosed values
                // Pop characters until the opening parenthesis is found
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop(); // Remove '(' from the stack
                char op = stack.pop(); // Get the operator
                char ans = evaluate(list, op); // Evaluate the enclosed expression
                stack.push(ans); // Push the result back onto the stack
            } else {
                if (ch != ',') { // Ignore commas
                    stack.push(ch); // Push other characters onto the stack
                }
            }
        }
        return stack.peek() == 't'; // Return true if the final result is 't'
    }

    /**
     * Evaluates a list of boolean values based on the given operator.
     *
     * @param list A list of boolean literals ('t' or 'f') to evaluate.
     * @param op The operator used to evaluate the list ('&', '|', or '!').
     * @return char Returns 't' for true and 'f' for false based on the evaluation.
     */
    public char evaluate(ArrayList<Character> list, char op) {
        if (op == '&') {
            // AND operation: returns 'f' if any value is 'f'
            return find(list, 'f') ? 'f' : 't';
        } else if (op == '|') {
            // OR operation: returns 't' if any value is 't'
            return find(list, 't') ? 't' : 'f';
        } else { // NOT operation
            // Returns the negation of the first value in the list
            return (list.get(0) == 't' ? 'f' : 't');
        }
    }

    /**
     * Checks if a specific value exists in the list.
     *
     * @param list A list of characters to search through.
     * @param val The character to find in the list.
     * @return boolean Returns true if the character is found, otherwise false.
     */
    public boolean find(ArrayList<Character> list, char val) {
        // Iterate through the list to find the value
        for (char ch : list) {
            if (ch == val) {
                return true; // Value found
            }
        }
        return false; // Value not found
    }
}
