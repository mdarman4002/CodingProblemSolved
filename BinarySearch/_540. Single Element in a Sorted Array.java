class Solution {
    /**
     * Finds the single non-duplicate element in a sorted array.
     * 
     * The array is assumed to have all elements appearing twice, except for one element which appears only once.
     * 
     * @param nums a sorted array of integers
     * @return the single non-duplicate element in the array
     */
    public int singleNonDuplicate(int[] nums) {
        /**
         * Initialize two pointers, start and end, to the start and end of the array, respectively.
         * We subtract 2 from the length of the array because we're using 0-based indexing.
         */
        int start = 0; 
        int end = nums.length - 2;

        /**
         * Binary search loop
         */
        while(start <= end){
            /**
             * Calculate the midpoint of the range [start, end]
             */
            int mid = (start + end) / 2;

            /**
             * Check if the element at index mid is equal to the element at index mid ^ 1.
             * If they are equal, it means that the single non-duplicate element is in the right half of the range.
             * Otherwise, it's in the left half.
             */
            if(nums[mid] == nums[mid ^ 1]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        /**
         * Return the single non-duplicate element, which is at index start
         */
        return nums[start];
    }
}
