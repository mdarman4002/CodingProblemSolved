class Solution {
    /**
     * Returns an array of missing rolls to achieve the given mean.
     * 
     * @param rolls the existing rolls
     * @param mean the target mean
     * @param n the number of missing rolls
     * @return an array of missing rolls, or an empty array if it's not possible
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length; // number of existing rolls
        int mn = m + n; // total number of rolls (existing + missing)
        int msum = 0; // sum of existing rolls
        for (int ele : rolls) {
            msum += ele; // calculate the sum of existing rolls
        }
        
        int[] newArray = new int[n]; // array to store the missing rolls
        
        // if the sum of existing rolls is already greater than or equal to the target mean, return an empty array
        if (msum >= mean * mn) {
            return new int[0];
        }
        
        int remainForN = (mean * mn) - msum; // remaining sum needed to achieve the target mean
        // if the remaining sum is not possible to distribute among the missing rolls, return an empty array
        if (remainForN / n == 0 || remainForN > n * 6) {
            return new int[0];
        }
        
        // if the remaining sum can be distributed evenly among the missing rolls, assign the same value to each
        if (remainForN / n == 6) {
            for (int i = 0; i < n; i++) {
                newArray[i] = 6; // assign 6 to each missing roll
            }
        } else {
            // distribute the remaining sum among the missing rolls, with some rolls getting an extra 1
            int base = remainForN / n; // base value for each missing roll
            int extra = remainForN % n; // number of extra rolls needed
            for (int i = 0; i < n; i++) {
                if (i < extra) {
                    newArray[i] = base + 1; // add 1 to the base value for extra rolls
                } else {
                    newArray[i] = base; // assign the base value to non-extra rolls
                }
            }

        // for(int i = 0; i < n; i++){
            // newArray[i] = base + (i < extra ? 1 : 0);
            // }
        }
        
        return newArray; // return the array of missing rolls
    }
}
