// this code will not run all cases beacuse there i used TreeSet instead of ArrayList or TreeMap

// class Solution {
//     public int maximumSum(int[] nums) {
//         HashMap<Integer,Integer> indexMap = new HashMap<>();
//         HashMap<Integer,TreeSet<Integer>> sumMap = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//             int num = nums[i];
//             int digitSum = findSum(num);
//             indexMap.put(num,digitSum);
//             if(!sumMap.containsKey(digitSum)){
//                 sumMap.put(digitSum, new TreeSet<>(Collections.reverseOrder()));
//             }

//              TreeSet<Integer> set = sumMap.get(digitSum);
//             set.add(num); 

//         }
//         int result = 0;
//         for(Map.Entry<Integer,TreeSet<Integer>> entry: sumMap.entrySet()){
//             int key = entry.getKey();
//             if(sumMap.get(key).size() > 1){

//                 int first = sumMap.get(key).first();
//                 int second = sumMap.get(key).higher(first);
//                 result = Math.max(result, first + second);
//             }
            
//         }
//         if(result == 0){
//             return -1;
//         }
//         return result;
        
//     }
//     public int findSum(int num){
//         int temp = num;
//         int sum = 0;
//         while(temp > 0){
//             sum += temp % 10;
//             temp = temp / 10;
//         }
//         return sum;
//     }
// }



import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        TreeMap<Integer, ArrayList<Integer>> sumMap = new TreeMap<>();

        for (int num : nums) {
            int digitSum = findSum(num);
            indexMap.put(num, digitSum);

            // Add the number to the list associated with its digit sum
            sumMap.putIfAbsent(digitSum, new ArrayList<>());
            sumMap.get(digitSum).add(num);
        }

        int result = -1; // Initialize result to -1 to handle cases with no valid pairs

        // Iterate over the entries in the TreeMap
        for (Map.Entry<Integer, ArrayList<Integer>> entry : sumMap.entrySet()) {
            ArrayList<Integer> numbers = entry.getValue();
            if (numbers.size() > 1) {
                // Sort the numbers to get the two largest
                numbers.sort((a, b) -> b - a); // Sort in descending order
                int first = numbers.get(0);
                int second = numbers.get(1);
                result = Math.max(result, first + second);
            }
        }

        return result;
    }

    public int findSum(int num) {
        int temp = num;
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp = temp / 10;
        }
        return sum;
    }

}
