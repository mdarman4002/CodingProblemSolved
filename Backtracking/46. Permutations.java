/**
 * This class generates all permutations of a given array of integers.
 */
class Solution {
    /**
     * This method generates all permutations of the input array and returns them as a list of lists.
     * 
     * @param nums The input array of integers.
     * @return A list of lists, where each inner list is a permutation of the input array.
     */
    public List<List<Integer>> permute(int[] nums) {
        int numsLen = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        permuteList(nums, 0, output, numsLen);
        return output;
    }

    /**
     * This method generates all permutations of the input array using backtracking.
     * 
     * @param nums The input array of integers.
     * @param index The current index in the array.
     * @param output The list of lists to store the permutations.
     * @param numsLen The length of the input array.
     */
    public void permuteList(int[] nums, int index, List<List<Integer>> output, int numsLen) {
        /**
         * Base case: If we have reached the end of the array, add the current permutation to the output.
         */
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int ele : nums) {
                list.add(ele);
            }
            output.add(list);
        } else {
            /**
             * Generate all permutations by swapping each element at the current index with the elements at the remaining indices.
             */
            for (int i = index; i < numsLen; i++) {
                swap(nums, i, index);
                permuteList(nums, index + 1, output, numsLen);
                swap(nums, i, index); // Backtrack and restore the original array.
            }
        }
    }

    /**
     * This method swaps two elements in the input array.
     * 
     * @param nums The input array of integers.
     * @param index1 The index of the first element to swap.
     * @param index2 The index of the second element to swap.
     */
    public void swap(int nums[], int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
