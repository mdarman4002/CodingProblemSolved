/**
 * The {@code Solution} class provides a method to determine if a given integer
 * can be expressed as a sum of distinct powers of three.
 */
class Solution {
    
    /**
     * Checks if the given integer {@code n} can be expressed as a sum of distinct
     * powers of three (i.e., 1, 3, 9, 27, ...).
     *
     * <p>
     * The method works by repeatedly dividing the number by 3 and checking the
     * remainder. If at any point the remainder is greater than 1, it indicates
     * that the number cannot be expressed as a sum of distinct powers of three,
     * and the method returns {@code false}. If the loop completes without finding
     * a remainder greater than 1, the method returns {@code true}.
     * </p>
     *
     * @param n the integer to check
     * @return {@code true} if {@code n} can be expressed as a sum of distinct
     *         powers of three; {@code false} otherwise
     */
    public boolean checkPowersOfThree(int n) {
        int rem = 0;
       
        while(n > 0){
            rem = n % 3;
            if(rem > 1){
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
