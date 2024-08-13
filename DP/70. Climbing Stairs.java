/**
 * This class provides a solution to the "Climbing Stairs" problem.
 */
class Solution {
    /**
     * Returns the number of ways to climb n stairs, where each step can be 1 or 2 stairs.
     * 
     * @param n the number of stairs
     * @return the number of ways to climb n stairs
     */
    public int climbStairs(int n) {
        // Use memoization to store intermediate results and avoid redundant calculations
        return pathCount(n, new int[n+1]);
    }

    /**
     * Recursive function to calculate the number of ways to climb n stairs.
     * 
     * @param n the number of stairs remaining to climb
     * @param memoArr an array to store intermediate results (memoization)
     * @return the number of ways to climb n stairs
     */
    public int pathCount(int n, int[] memoArr) {
        // Base case: if there are no stairs left to climb, there is only one way (i.e., we've reached the top)
        if (n == 0) {
            return 1;
        }
        // Base case: if we've gone past the top of the stairs, there are no ways to climb
        if (n < 0) {
            return 0;
        }
        // If we've already calculated the result for this number of stairs, return the memoized value
        if (memoArr[n] != 0) {
            return memoArr[n];
        }
        // Calculate the number of ways to climb n stairs by considering two possibilities:
        // 1. Take one step (n-1 stairs remaining)
        int oneStep = pathCount(n-1, memoArr);
        // 2. Take two steps (n-2 stairs remaining)
        int twoStep = pathCount(n-2, memoArr);
        // The total number of ways is the sum of these two possibilities
        int pc = oneStep + twoStep;
        // Store the result in the memoization array to avoid redundant calculations
        memoArr[n] = pc;
        return pc;
    }
}
