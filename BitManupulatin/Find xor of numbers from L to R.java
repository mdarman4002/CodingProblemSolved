class Solution {
    /**
     * Finds the XOR of all numbers in the range [l, r]
     * 
     * @param l the lower bound of the range (inclusive)
     * @param r the upper bound of the range (inclusive)
     * @return the XOR of all numbers in the range [l, r]
     */
    public static int findXOR(int l, int r) {
        // int xor = l;
        // for(int i = l+1 ; i <= r; i++){
        //     xor ^= i;
        // }
        // return xor;
        // Instead of iterating through the range, we can use the property of XOR
        // to simplify the calculation. The XOR of a range can be calculated as
        // the XOR of the XOR of the ranges [0, l-1] and [0, r].
        return func(l-1) ^ func(r);
    }

    /**
     * Calculates the XOR of all numbers in the range [0, n]
     * 
     * @param n the upper bound of the range (inclusive)
     * @return the XOR of all numbers in the range [0, n]
     */
    public static int func(int n){
        // The XOR of a range [0, n] follows a periodic pattern of 4:
        // - If n is a multiple of 4, the XOR is n
        // - If n is 1 more than a multiple of 4, the XOR is 1
        // - If n is 2 more than a multiple of 4, the XOR is n+1
        // - If n is 3 more than a multiple of 4, the XOR is 0
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n+1;
        return 0;
    }
}
