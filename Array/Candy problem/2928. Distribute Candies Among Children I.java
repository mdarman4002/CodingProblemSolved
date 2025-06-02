class Solution {
    public int distributeCandies(int n, int limit) {
        int i, j, k;
        int sum = 0;
        int count = 0;
        for(i = 0; i <= limit; i++){
            for(j = 0; j <= limit; j++){
                for(k = 0; k <= limit; k++){
                    sum += i + j+ k;
                    if(sum == n){
                        count++;
                    }
                    sum = 0;
                }
                
            }
        }
        return count;
    }
}


class Solution {
    public int distributeCandies(int n, int limit) {
        return candies(n,limit,0);
    }public int candies(int n, int limit, int child){
        if(child == 3){
            if(n == 0){
                return 1;
            }
            return 0;
        }
        int ways = 0;
        for(int assign = 0; assign <= limit; assign++){
            ways += candies(n-assign,limit,child+1);
        }
        return ways;
    }

}




class Solution {
    private int[][] memo;
    private int limit;

    public int distributeCandies(int n, int limit) {
        this.limit = limit;
        memo = new int[n + 1][4]; // child ranges from 0 to 3, n ranges from 0 to n
        return candies(n, 0);
    }

    private int candies(int n, int child) {
        if (child == 3) {
            return n == 0 ? 1 : 0;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n][child] != 0) {
            return memo[n][child];
        }

        int ways = 0;
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
