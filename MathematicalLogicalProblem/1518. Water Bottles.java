class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int output = numBottles;
        while(numBottles >= numExchange){
            int newbottles = numBottles / numExchange;
            numBottles = numBottles % numExchange + newbottles;
            output +=  newbottles ;
        }
        return output;
    }
}
