/**
 * The Solution class provides a method to compute the nth Fibonacci number
 * using memoization to optimize the recursive approach.
 */
class Solution {
    
    /**
     * Computes the nth Fibonacci number.
     *
     * @param n The index of the Fibonacci number to compute (0-based).
     * @return The nth Fibonacci number.
     */
    public int fib(int n) {
        // Create a memoization array to store previously computed Fibonacci numbers
        int memo[] = new int[n + 1];
        return fibMemo(n, memo);
    }

    /**
     * A helper method that computes the nth Fibonacci number using recursion
     * and memoization.
     *
     * @param n The index of the Fibonacci number to compute (0-based).
     * @param memo An array used to store previously computed Fibonacci numbers
     *             to avoid redundant calculations.
     * @return The nth Fibonacci number.
     */
    public int fibMemo(int n, int[] memo) {
        // Base cases: return n for Fibonacci(0) and Fibonacci(1)
        if (n == 0 || n == 1) {
            memo[n] = n; // Store the result in the memo array
            return n;
        }

        // If the value has already been computed, return it from the memo array
        if (memo[n] != 0) {
            return memo[n];
        }

        // Compute the Fibonacci number recursively and store it in the memo array
        int series = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo[n] = series; // Store the computed value in the memo array
        return memo[n];
    }
}


------------------------------Tabulation----------------------------------

class Solution {
    public int fib(int n) {
        //int memo[] = new int[n+1];
        int tabulation[] = new int[n+1];
        if(n <= 1){
            return n;
        }
        tabulation[0] = 0;
        tabulation[1] = 1;
        for(int state = 2; state <= n; state++){
            tabulation[state] = tabulation[state - 1] + tabulation[state - 2];
        }
        return tabulation[n];
       
       
    }
}
