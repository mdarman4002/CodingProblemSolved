class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i <= 2 * limit)
                res += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return res;
    }
}

class Solution { //TLE
    public long distributeCandies(int n, int limit) {
        return candies(n,limit,0);
    }public long candies(int n, int limit, int child){
        if(child == 3){
            if(n == 0){
                return 1;
            }
            return 0;
        }
        long ways = 0;
        for(int assign = 0; assign <= limit; assign++){
            ways += candies(n-assign,limit,child+1);
        }
        return ways;
    }

}


//TLE
class Solution {
    private Long[][] memo;
    private int limit;

    public long distributeCandies(int n, int limit) {
        this.limit = limit;
        memo = new Long[n + 1][4]; // child ranges from 0 to 3, n ranges from 0 to n
        return candies(n, 0);
    }

    private long candies(int n, int child) {
        if (child == 3) {
            return n == 0 ? 1 : 0;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n][child] != null) {
            return memo[n][child];
        }

        long ways = 0;
        for (int assign = 0; assign <= Math.min(limit,n); assign++) {
            if (assign <= n) {
                ways += candies(n - assign, child + 1);
            } else {
                break; // no need to check further if assign > n
            }
        }
        memo[n][child] = ways;
        return ways;
    }
}


class Solution {
    public long distributeCandies(int n, int limit) {
        long ways = 0;

        // Loop through possible candies for the first child
        int minCh1 = Math.max(0, n - 2 * limit);
        int maxCh1 = Math.min(n, limit);

        for (int i = minCh1; i <= maxCh1; i++) {
            int remaining = n - i;

            int minCh2 = Math.max(0, remaining - limit);
            int maxCh2 = Math.min(remaining, limit);

            ways += (maxCh2 - minCh2 + 1);
        }

        return ways;
    }
}
