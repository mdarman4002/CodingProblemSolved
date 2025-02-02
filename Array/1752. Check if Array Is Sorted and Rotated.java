class Solution {
    // Method to check if the array can be non-decreasing by modifying at most one element.
    public boolean check(int[] nums) {
        // Variable to keep track of the number of times a pair is out of order.
        int countOutOfOrder = 0;
      
        // 'n' is the length of the array.
        int n = nums.length;
      
        // Iterate over the elements of the array.
        for (int i = 0; i < n; ++i) {
            // Check if the current element is greater than the next element 
            // The next element of the last item is the first item, hence the modulo operation.
            if (nums[i] > nums[(i + 1) % n]) {
                // Increment the out of order count.
                ++countOutOfOrder;
            }
        }
      
        // The array is non-decreasing if there is at most one out-of-order pair.
        return countOutOfOrder <= 1;
    }
}
