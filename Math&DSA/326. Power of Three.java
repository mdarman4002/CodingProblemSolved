class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)return false;
        for(int i = 0; i < 20; i++){
            long curPow =(long) Math.pow(3,i);
            if(curPow == n)return true;
            else if(curPow > n)return false;
        }
        return false;
    }
}
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)return false;
        long limit = (long) Math.pow(2,31);
        return findHighestValue(limit, 1) % n == 0;
    }
    public int findHighestValue(long limit, int maxNum){
        while(true){
            int nextPower = 3 * maxNum;
            if(nextPower > limit || nextPower <= 0){
                break;
            }
            maxNum = nextPower;
        }
        return maxNum;
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)return false;
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)return false;
        long maxLimit = (long) Math.pow(3,19);
        return ((maxLimit % n) == 0);
    }
}
