class Solution {
    /**
     * Returns true if the occurrences of each element in the array are unique, false otherwise.
     * 
     * @param arr the input array
     * @return true if the occurrences of each element are unique, false otherwise
     */
    public boolean uniqueOccurrences(int[] arr) {
        // Create a hashmap to store the frequency of each element in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            // Increment the frequency of the current element
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        // Create a hashset to store the unique frequencies
        HashSet<Integer> set = new HashSet<>();
        for (int key : map.keySet()) {
            // Check if the frequency of the current element is already in the set
            if (set.contains(map.get(key))) {
                // If it is, return false because the occurrences are not unique
                return false;
            } else {
                // If not, add the frequency to the set
                set.add(map.get(key));
            }
        }
        // If we reach this point, all frequencies are unique, so return true
        return true;
    }
}
