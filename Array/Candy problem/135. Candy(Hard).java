import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1; // Each child gets at least one candy

        int[] l2r = new int[n];
        int[] r2l = new int[n];
        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);
        int res = 0;

        // Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l2r[i] = l2r[i - 1] + 1;
            }
        }

        // Right to Left
        for (int i = n - 2; i >= 0; i--) { 
            if (ratings[i] > ratings[i + 1]) {
                r2l[i] = r2l[i + 1] + 1;
            }
        }

        // Calculate the maximum candies needed
        for (int i = 0; i < n; i++) {
            res += Math.max(r2l[i], l2r[i]);
        }

        return res;
    }
}




//O(1) space and O(n) time
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int candy = n;
        while(i < n){
            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }
            // climb increasing
            int peak = 0;
            while(ratings[i] > ratings[i-1]){
                peak++;
                candy += peak;
                i++;
                if(i == n)return candy;
            }
            // decline decreasing
            int dip = 0;
            while(i < n && ratings[i] < ratings[i-1]){
                dip++;
                candy +=dip;
                i++;
            }
            candy -= Math.min(peak, dip);
            if(i == n)return candy;
        }
        return candy;
    }
}
