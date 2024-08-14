/**
 * Class Solution
 * 
 * This class provides a solution to the combination sum problem.
 */
class Solution {
    /**
     * Method: combinationSum
     * 
     * Finds all possible combinations of candidates that sum up to the target.
     * 
     * @param candidates an array of integers representing the possible candidates for the combination sum
     * @param target an integer representing the target sum
     * @return a list of lists of integers, where each inner list represents a combination of candidates that sums up to the target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Initialize the result list
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Initialize the current combination list
        ArrayList<Integer> current = new ArrayList<>();
        // Call the recursive helper function
        findRecur(candidates, target, 0, result, current);
        // Return the result
        return result;
    }

    /**
     * Method: findRecur
     * 
     * Recursive helper function to find all possible combinations of candidates that sum up to the target.
     * 
     * @param candidates an array of integers representing the possible candidates for the combination sum
     * @param target an integer representing the target sum
     * @param index an integer representing the current index in the candidates array
     * @param result a list of lists of integers to store the result
     * @param current a list of integers to store the current combination
     */
    public void findRecur(int[] candidates, int target, int index, List<List<Integer>> result, ArrayList<Integer> current) {
        // Base case: if we have reached the end of the candidates array
        if (index == candidates.length) {
            // If the target sum is 0, add the current combination to the result
            if (target == 0) {
                result.add(new ArrayList<Integer>(current));
            }
            // Return to backtrack
            return;
        }
        // Try picking the current candidate
        if (target >= candidates[index]) {
            // Add the current candidate to the current combination
            current.add(candidates[index]);
            // Recursively call the helper function with the updated target and index
            findRecur(candidates, target - candidates[index], index, result, current);
            // Remove the last added candidate from the current combination (backtracking)
            current.remove(current.size() - 1);
        }
        // Try not picking the current candidate
        // Recursively call the helper function with the same target and incremented index
        findRecur(candidates, target, index + 1, result, current);
    }
}
