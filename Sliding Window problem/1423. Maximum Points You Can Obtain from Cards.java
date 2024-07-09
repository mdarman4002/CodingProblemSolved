
class Solution {
    // public static void main(String[] args) {
    //     int[] cardPoints = {1,2,3,4,5,6,1};
    //     int k = 3;
    //    maxScore(cardPoints, k);
    // }
    public int  maxScore(int[] cardPoints, int k) {
        int leftsum = 0; int rightsum = 0; int maxsum = 0;
     
        for(int i = 0; i < k; i++){
            leftsum += cardPoints[i];
            
        }
        
        maxsum = leftsum;
       // System.out.println("max leftsum: "+ leftsum);
        int rindex = cardPoints.length-1;
        for(int j = k-1; j >= 0; j--){
            leftsum = leftsum - cardPoints[j];
            rightsum = rightsum + cardPoints[rindex];
            rindex -= 1;
            maxsum = Math.max(maxsum, leftsum+rightsum);
           // System.out.println("locally max sum: "+ maxsum);
        }
        //System.out.println("Globally maxsum: "+ maxsum);
        return maxsum;
    }
}

// class Solution {
//     public int maxScore(int[] cardPoints, int k) {
//         int leftsum = 0, rightsum = 0, maxsum = 0;
        
//         for (int i = 0; i < k; i++) {
//             leftsum += cardPoints[i];
//         }
        
//         maxsum = leftsum;
    
//         for (int i = 0; i < k; i++) {
//             leftsum -= cardPoints[k - 1 - i];
//             rightsum += cardPoints[cardPoints.length - 1 - i];
//             maxsum = Math.max(maxsum, leftsum + rightsum);
//         }
        
//         return maxsum;
//     }
// }
