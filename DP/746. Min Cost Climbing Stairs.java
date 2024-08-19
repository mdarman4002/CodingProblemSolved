/**
 * This class provides a solution to the "Min Cost Climbing Stairs" problem.
 * 
 * The problem states that you are climbing a staircase with n steps, and at each step, you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * 
 * This solution uses dynamic programming to solve the problem in O(n) time complexity.
 */
class Solution {
    /**
     * This method calculates the minimum cost to reach the top of the stairs.
     * 
     * @param cost an array of integers representing the cost of climbing each step
     * @return an integer representing the minimum cost to reach the top of the stairs
     */
    public int minCostClimbingStairs(int[] cost) {
        // Get the length of the cost array
        int len = cost.length;
        
        // Create a dynamic programming array to store the minimum cost to reach each step
        int[] dp = new int[len+1];
        
        // Initialize the first two steps
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Iterate from the third step to the last step
        for(int i = 2; i < len ; i++){
            // Calculate the minimum cost to reach the current step
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        
        // Return the minimum cost to reach the top of the stairs
        return Math.min(dp[len-1], dp[len-2]);
    }
}


// other way
 int N = cost.length;

        // Handle edge cases where cost array is too small
        if (N == 0) return 0;
        if (N == 1) return cost[0];
        if (N == 2) return Math.min(cost[0], cost[1]);

        // Initialize dp array
        int[] dp = new int[N + 1];

        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Fill dp array iteratively
        for (int i = 2; i < N; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }

        // The result is the minimum cost to reach the last step
        return Math.min(dp[N - 1], dp[N - 2]);
    }
}
