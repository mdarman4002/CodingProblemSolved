import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public int longestSquareStreak(int[] nums) {
        // HashSet to store unique elements from the input array
        HashSet<Integer> set = new HashSet<>();
        // ArrayList to keep track of the current square streak
        ArrayList<Integer> list = new ArrayList<>();
       
        // Populate the HashSet with elements from the input array
        for (int ele : nums) {
            set.add(ele);
        }

        // Variable to track the maximum length of the square streak found
        int max = 0;
        
        // Iterate through each element in the input array
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            
            // Start a new streak with the current element
            list.add(ele);
            // Continue squaring the last element in the list and checking if it's in the set
            while (set.contains((int) Math.pow(list.get(list.size() - 1), 2))) {
                // Add the square of the last element to the list
                list.add((int) Math.pow(list.get(list.size() - 1), 2));
            }
            // Update the maximum streak length found
            max = Math.max(max, list.size());
            // Clear the list for the next iteration
            list.clear();
        }
        
        // If the maximum streak length is 1 (which means no valid streak was found), return -1
        return max == 1 ? -1 : max;
    }
}
