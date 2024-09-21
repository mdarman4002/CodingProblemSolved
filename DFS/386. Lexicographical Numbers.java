/**
 * Solution class for generating lexical order of integers up to n.
 */
class Solution {
    /**
     * Generates the lexical order of integers up to n.
     * 
     * @param n The upper limit of the lexical order.
     * @return A list of integers in lexical order.
     */
    public List<Integer> lexicalOrder(int n) {
        // Initialize an empty list to store the result
        ArrayList<Integer> list = new ArrayList<>();
        
        // Start the depth-first search from each digit from 1 to 9
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, list);
        }
        
        // Return the list of integers in lexical order
        return list;
    }

    /**
     * Performs a depth-first search to generate the lexical order.
     * 
     * @param cur The current number being processed.
     * @param n The upper limit of the lexical order.
     * @param list The list to store the result.
     */
    public void dfs(int cur, int n, ArrayList<Integer> list) { // pre-order traversal 
        // Base case: if the current number exceeds n, stop the search
        if (cur > n) {
            return;
        }
        
        // Add the current number to the list
        list.add(cur);
        
        // Recursively search for numbers with the next digit
        for (int digit = 0; digit <= 9; digit++) {
            // If the next number exceeds n, stop the search
            if (cur * 10 + digit > n) {
                break;
            }
            // Recursively call the dfs function with the next number
            dfs(cur * 10 + digit, n, list);
        }
    }
}
