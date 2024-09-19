class Solution {

    /**
     * This function returns the index at which the target should be inserted in a sorted array.
     * If the target is found in the array, it returns the index of the target.
     * If the target is not found, it returns the index where the target should be inserted
     * to maintain the sorted order.
     * 
     * @param nums  A sorted array of integers.
     * @param target  The integer value to search for or insert.
     * @return  The index of the target if found, otherwise the index where it should be inserted.
     */
    public int searchInsert(int[] nums, int target) {
        // Initialize the low and high pointers for binary search.
        int low = 0;
        int high = nums.length - 1;
        
        // Early return: If target is greater than the largest element in the array,
        // it should be inserted at the end (i.e., position high + 1).
        if (target > nums[high]) {
            return high + 1;
        }

        // Perform binary search.
        while (low <= high) {
            // Calculate mid-point of the current low and high.
            int mid = low + (high - low) / 2;

            // If the target is found at mid, return its index.
            if (nums[mid] == target) {
                return mid;
            }
            // If the target is greater than the element at mid, search in the right half.
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            // If the target is smaller than the element at mid, search in the left half.
            else {
                high = mid - 1;
            }
        }

        // If the target is not found, low will point to the index where the target should be inserted.
        return low;
    }
}
