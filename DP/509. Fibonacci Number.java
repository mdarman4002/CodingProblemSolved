/**
 * This class provides a solution to the Fibonacci sequence problem.
 */
class Solution {
    /**
     * Returns the nth Fibonacci number.
     * 
     * @param n the position of the Fibonacci number to calculate
     * @return the nth Fibonacci number
     */
    public int fib(int n) {
        // Use memoization to store intermediate results and avoid redundant calculations
        return fibo(n, new int[n+1]);
    }

    /**
     * Recursive function to calculate the nth Fibonacci number using memoization.
     * 
     * @param n the position of the Fibonacci number to calculate
     * @param memoArr an array to store intermediate results (memoization)
     * @return the nth Fibonacci number
     */
    public int fibo(int n, int[] memoArr) {
        // Base case: if n is 0 or 1, return the value directly (F(0) = 0, F(1) = 1)
        if (n == 0 || n == 1) {
            return n;
        }
        // If we've already calculated the result for this position, return the memoized value
        if (memoArr[n] != 0) {
            return memoArr[n];
        }
        // Calculate the nth Fibonacci number by recursively calling fibo for n-1 and n-2
        int n_1 = fibo(n-1, memoArr);
        int n_2 = fibo(n-2, memoArr);
        // The nth Fibonacci number is the sum of the (n-1)th and (n-2)th Fibonacci numbers
        int curFib = n_1 + n_2;
        // Store the result in the memoization array to avoid redundant calculations
        memoArr[n] = curFib;
        return memoArr[n];
    }
}
