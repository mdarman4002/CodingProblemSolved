import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        if (arr == null || k <= 0) {
            return "";
        }

        HashMap<String, Integer> map = new HashMap<>();
        
        // Count occurrences of each string
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        List<String> distinctList = new ArrayList<>();
        
        // Collect distinct strings (i.e., strings that appear exactly once)
        for (String str : arr) {
            if (map.get(str) == 1) {
                distinctList.add(str);
            }
        }
        
        // Return the k-th distinct string (1-based index)
        if (k <= distinctList.size()) {
            return distinctList.get(k - 1);
        }
        
        return "";
    }
}
