import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Solution class for finding the intersection of two integer arrays.
 */
class Solution {
    /**
     * Returns an array of integers that are common to both input arrays.
     * 
     * @param nums1 the first input array
     * @param nums2 the second input array
     * @return an array of integers that are common to both input arrays
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create a hash set to store the elements of the first array
        HashSet<Integer> nums1Set = new HashSet<>();
        for (int ele : nums1) {
            // Add each element of the first array to the hash set
            nums1Set.add(ele);
        }

        // Create a hash set to store the intersection of the two arrays
        HashSet<Integer> intersection = new HashSet<>();
        for (int ele : nums2) {
            // Check if the current element of the second array is in the first array
            if (nums1Set.contains(ele)) {
                // If it is, add it to the intersection set
                intersection.add(ele);
            }
        }

        // Create a list to store the intersection elements
        List<Integer> list = new ArrayList<>();
        for (int ele : intersection) {
            // Add each element of the intersection set to the list
            list.add(ele);
        }

        // Create an array to store the output
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // Copy the elements from the list to the output array
            output[i] = list.get(i);
        }
        return output;
    }
}
