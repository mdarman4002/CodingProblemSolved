import java.util.HashMap;
import java.util.TreeSet;

/**
 * The NumberContainers class allows for storing numbers at specific indices
 * and provides functionality to change the number at an index and find the
 * minimum index associated with a given number.
 */
class NumberContainers {

    private HashMap<Integer, Integer> indexToNum; // Maps index to the number at that index
    private HashMap<Integer, TreeSet<Integer>> NumToIndex; // Maps number to a set of indices where it appears

    /**
     * Initializes a new instance of the NumberContainers class.
     */
    public NumberContainers() {
        indexToNum = new HashMap<>();
        NumToIndex = new HashMap<>();
    }
    
    /**
     * Changes the number at the specified index.
     * If the index already has a number, it updates the number and
     * removes the index from the previous number's set of indices.
     *
     * @param index The index at which to change the number.
     * @param number The new number to be stored at the specified index.
     */
    public void change(int index, int number) {
        // If the index already has a number, remove it from the previous number's set
        if (indexToNum.containsKey(index)) {
            int prev = indexToNum.get(index);
            NumToIndex.get(prev).remove(index);
            // If the set for the previous number is empty, remove it from the map
            if (NumToIndex.get(prev).size() == 0) {
                NumToIndex.remove(prev);
            }
        }

        // Update the index to number mapping
        indexToNum.put(index, number);
        // Add the index to the new number's set of indices
        NumToIndex.putIfAbsent(number, new TreeSet<>());
        NumToIndex.get(number).add(index);
    }
    
    /**
     * Finds the minimum index associated with the specified number.
     * If the number does not exist, it returns -1.
     *
     * @param number The number for which to find the minimum index.
     * @return The minimum index associated with the number, or -1 if the number does not exist.
     */
    public int find(int number) {
        // Check if the number exists and return the minimum index or -1
        if (!NumToIndex.containsKey(number)) {
            return -1;
        }
        return NumToIndex.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index, number);
 * int param_2 = obj.find(number);
 */
