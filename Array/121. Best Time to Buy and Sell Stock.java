class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int max = 0; int min = prices[0];
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        for(int i = 0; i < len; i++){
            int cost = prices[i] - min;
            max = Math.max(max, cost);
            min = Math.min(min, prices[i]);
        }return max;
        // for(int i = 0; i < len-1; i++){
        //     for(int j = i+1; j < len; j++){
        //         max = Math.max(max,prices[j] - prices[i]);
        //     }
        // }return max; // time limit exceeded;
    }
}

