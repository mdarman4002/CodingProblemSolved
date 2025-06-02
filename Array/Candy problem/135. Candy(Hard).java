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
