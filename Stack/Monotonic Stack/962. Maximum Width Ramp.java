class Solution {
    /**
     * Returns the maximum width of a ramp in the given array of integers.
     * A ramp is defined as a subarray where the elements are in non-decreasing order.
     *
     * @param nums the input array of integers
     * @return the maximum width of a ramp
     */
    public int maxWidthRamp(int[] nums) {
        // Initialize a stack to store indices of elements in decreasing order
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array from left to right
        for (int i = 0; i < nums.length; i++) {
            // If the stack is empty or the current element is smaller than the top of the stack,
            // push the current index to the stack
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        // Initialize the maximum width of the ramp
        int res = Integer.MIN_VALUE;

        // Iterate through the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // While the stack is not empty and the top of the stack is smaller or equal to the current element,
            // pop the top of the stack and update the maximum width of the ramp
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(res, i - stack.peek());
                stack.pop();
            }

            // If the stack is empty, break the loop
            if (stack.isEmpty()) {
                break;
            }
        }

        // Return the maximum width of the ramp
        return res;
    }
}
