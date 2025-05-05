// class Solution {
//     public int numEquivDominoPairs(int[][] dominoes) {
//         // for(int domino[]:dominoes){

//         // }
//         int count = 0;
//         for(int i = 0; i < dominoes.length-1; i++){
//             int a = dominoes[i][0];
//             int  b = dominoes[i][1];
//             // int c = dominoes[i+1][0];
//             // int d= dominoes[i+1][1];
//             for(int j = i+1; j < dominoes.length; j++){
//                  int c = dominoes[j][0];
//                  int d= dominoes[j][1];
//                  if((a == c && b == d) || (a == d &&  b == c)){
//                 count++;
//             }

//             }
            
//         }
//         return count;
//     }
// }





// class Solution {
//     public int numEquivDominoPairs(int[][] dominoes) {
//         HashMap<String, Integer> map = new HashMap<>();
//         int pairs = 0;

//         for (int[] domino : dominoes) {
//             // Create a canonical representation
//             int a = domino[0];
//             int b = domino[1];
//             if(a > b){
//                 int temp = a;
//                 a = b;
//                 b = temp;
//             }
//             String key = a +","+b;
//             //String key = a < b ? a + "," + b : b + "," + a; // Use a string as the key

//             // Count occurrences of each domino
//             map.put(key, map.getOrDefault(key, 0) + 1);
//         }

//         // Calculate the number of pairs
//         for (int count : map.values()) {
//             if (count > 1) {
//                 pairs += count * (count - 1) / 2; // Combination of count taken 2 at a time
//             }
//         }

//         return pairs;
//     }
// }





// import java.util.HashMap;

// class Solution {
//     public int numEquivDominoPairs(int[][] dominoes) {
//         // Outer HashMap with key as a HashMap<Integer,Integer> representing the domino counts
//         HashMap<HashMap<Integer,Integer>, Integer> map = new HashMap<>();
//         int pairs = 0;

//         for(int[] domino : dominoes) {
//             int a = domino[0];
//             int b = domino[1];
//             // Create a new inner HashMap to represent this domino
//             HashMap<Integer,Integer> innerMap = new HashMap<>();
//             // Put counts for each number (both 1 since domino has two numbers)
//             innerMap.put(a, innerMap.getOrDefault(a, 0) + 1);
//             innerMap.put(b, innerMap.getOrDefault(b, 0) + 1);

//             // Get current count of this domino representation
//             int count = map.getOrDefault(innerMap, 0);

//             // Add pairs with the new domino (every new domino can form pairs with all previous identical ones)
//             pairs += count;

//             // Update map count
//             map.put(innerMap, count + 1);
//         }
//         return pairs;
//     }
// }



// class Solution {
//     public int numEquivDominoPairs(int[][] dominoes) {
//         HashMap<Integer,Integer> map = new HashMap<>();

//         for(int[] domino: dominoes){
//             int a = domino[0];
//             int b = domino[1];
//             if(a > b){
//                 int temp = a;
//                 a = b;
//                 b = temp;
//             }
//             int sumAB = a * 10 + b;
//             map.put(sumAB, map.getOrDefault(sumAB, 0)+ 1);

//         }
//         int res = 0;
//         for(int val: map.values()){
//             if(val > 0){
//                 res += (val * (val - 1)/2);
//             }
//         }
//         return res;
//     }
// }




// class Solution {
//     public int numEquivDominoPairs(int[][] dominoes) {
//         // HashMap<Integer,Integer> map = new HashMap<>();
//         int map[] = new int[10000];
//         for(int[] domino: dominoes){
//             int a = domino[0];
//             int b = domino[1];
//             if(a > b){
//                 int temp = a;
//                 a = b;
//                 b = temp;
//             }
//             int sumAB = a * 10 + b;
//             map[sumAB]++;
//             //map.put(sumAB, map.getOrDefault(sumAB, 0)+ 1);

//         }
//         int res = 0;
//         //for(int val: map.values()){
//         for(int val: map){
//             if(val > 0){
//                 res += (val * (val - 1)/2);
//             }
//         }
//         return res;
//     }
// }





class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
     
        int map[] = new int[100];
        int res = 0;
        for(int[] domino: dominoes){
            int a = domino[0];
            int b = domino[1];
            int sumAB = Math.min(a,b)*10 + Math.max(a,b);
            
            res += map[sumAB];
            map[sumAB]++;
        }
       
        return res;
    }
}
