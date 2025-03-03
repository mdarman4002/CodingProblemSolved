//--------1st way using recursion------------
class Solution {
    public int climbStairs(int n) {
        // Base case: if n is 1 or 2, return n
        if (n <= 2) {
            return n;
        }
        // Recursive case: sum of the ways to climb (n-1) and (n-2) steps
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}



// -------------2nd way top-down approach(memoization) --------------

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1]; // Array to store results of subproblems
        return memoization(n, dp);
    }

    public int memoization(int n, int dp[]) {
        // Base case: if n is 1 or 2, return n
        if (n <= 2) {
            dp[n] = n;
        }
        // If the result is already computed, return it
        if (dp[n] != 0) {
            return dp[n];
        }
        // Store the result in dp array
        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
        return dp[n];
    }
}





//-------------3rd way Bottom - up approach(Tabulation)-------------------------
class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1]; // Array to store results of subproblems
        // Base cases
        if (n <= 2) {
            return n;
        }
        dp[0] = 0; // 0 ways to climb 0 steps
        dp[1] = 1; // 1 way to climb 1 step
        dp[2] = 2; // 2 ways to climb 2 steps
        int res = 0;
        // Fill the dp array iteratively
        for (int i = 3; i <= n; i++) {
            res = dp[i - 1] + dp[i - 2]; // Number of ways to reach step i
            dp[i] = res; // Store the result
        }
        return res; // Return the result for n steps
    }
}
