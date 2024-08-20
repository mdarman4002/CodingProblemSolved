class Solution {
    /**
     * Finds the majority element in an array, which is the element that appears more than n/2 times.
     * 
     * @param nums the input array
     * @return the majority element
     */
    public int majorityElement(int[] nums) {
        // Create a HashMap to store the count of each element
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // Iterate over the input array
        for (int ele : nums) {
            // If the element is already in the map, increment its count
            if (hm.containsKey(ele)) {
                hm.put(ele, hm.get(ele) + 1);
            } 
            // If the element is not in the map, add it with a count of 1
            else {
                hm.put(ele, 1);
            }
        }
        
        // Calculate the target count, which is n/2
        int target = nums.length / 2;
        
        // Initialize the output variable to store the majority element
        int output = 0;
        
        // Iterate over the map's entries to find the majority element
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            // If the count of the current element is greater than the target, it's the majority element
            if (value > target) {
                output = key;
                break; // Exit the loop since we've found the majority element
            }
        }
        
        // Return the majority element
        return output;
    }
}
