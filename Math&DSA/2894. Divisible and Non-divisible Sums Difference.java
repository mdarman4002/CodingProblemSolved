class Solution {
    public int differenceOfSums(int n, int m) {
        int sumOfDivisible = 0;
        int sumOfNonDivisible = 0;
        for(int i = 1; i <= n; i++){
            if(i % m == 0){
                sumOfDivisible += i;
            }else{
                sumOfNonDivisible += i;
            }
        }
        return sumOfNonDivisible - sumOfDivisible;
    }
}
