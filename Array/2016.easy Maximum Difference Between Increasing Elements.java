// class Solution {
//     public int maximumDifference(int[] nums) {
//         int diff = -1;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i+1; j < nums.length ; j++) {
//                 if(nums[i]== nums[j]) continue;
//                 if (nums[j] - nums[i] > diff) {
//                     diff = nums[j] - nums[i];
//                 }
//             }
//         }
//         return diff;
//     }
// }


class Solution {
    public int maximumDifference(int[] nums) {
        int minValue = nums[0]; // Initialize minValue to the first element
        int maxDiff = -1; // Initialize maxDiff to -1, indicating no valid difference found yet
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Calculate the difference between the current element and the minimum value
            if (nums[i] > minValue) {
                maxDiff = Math.max(maxDiff, nums[i] - minValue);
            }
            // Update the minimum value if the current element is smaller
            minValue = Math.min(minValue, nums[i]);
        }
        
        return maxDiff; // Return the maximum difference found, or -1 if none exists
    }
}
