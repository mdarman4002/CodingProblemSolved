import java.util.HashMap;

class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int luckyNumber = -1; 
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key == value) {
                luckyNumber = Math.max(luckyNumber, key);
            }
        }
        
        return luckyNumber; 
    }
}
