/**
 * The Solution class provides a method to calculate the maximum sum of 
 * an ascending subarray in a given array of integers.
 */
class Solution {
    
    /**
     * Calculates the maximum sum of an ascending subarray in the given array of integers.
     * An ascending subarray is defined as a contiguous subarray where each element 
     * is greater than the previous one.
     *
     * @param nums an array of integers representing the input array
     * @return the maximum sum of any ascending subarray within the input array
     *
     * The method iterates through the array, maintaining a current sum of the 
     * ascending subarray and updating the maximum sum found so far whenever 
     * the ascending order is broken.
     *
     * Example:
     * <pre>
     * Solution solution = new Solution();
     * int[] nums = {10, 20, 30, 5, 10, 50};
     * int result = solution.maxAscendingSum(nums);
     * System.out.println(result); // Output: 65 (30 + 5 + 10 + 50)
     * </pre>
     */
    public int maxAscendingSum(int[] nums) {
        int preMax = nums[0];
        int curMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                curMax += nums[i];
            }
            if(nums[i-1] >= nums[i]){
                if(curMax > preMax){
                    preMax = curMax;
                }
                curMax = 0;
                curMax += nums[i];
            }
        }
        return Math.max(curMax, preMax);
    }
}
