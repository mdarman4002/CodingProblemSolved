import java.util.HashSet;

/**
 * The Solution class provides a method to calculate the number of distinct tile arrangements
 * that can be formed using the given string of tiles. Each tile can be used only once in each arrangement.
 */
class Solution {

    /**
     * Calculates the number of distinct tile possibilities that can be formed from the given tiles.
     *
     * @param tiles A string representing the available tiles.
     * @return The number of distinct tile arrangements that can be formed.
     */
    public int numTilePossibilities(String tiles) {
        boolean used[] = new boolean[tiles.length()]; // Array to track used tiles
        HashSet<String> set = new HashSet<>(); // Set to store unique arrangements
        backtrack("", tiles, used, set); // Start backtracking with an empty current arrangement
        return set.size() - 1; // Return the size of the set minus 1 (to exclude the empty arrangement)
    }

    /**
     * Backtracks to find all unique arrangements of tiles.
     *
     * @param cur The current arrangement of tiles being formed.
     * @param tiles The original string of tiles.
     * @param used An array indicating which tiles have been used in the current arrangement.
     * @param set A set to store unique arrangements.
     */
    public void backtrack(String cur, String tiles, boolean[] used, HashSet<String> set) {
        if(set.contains(cur))return;
        //if(set.contains(cur))return; pruning
        // Add the current arrangement to the set
        set.add(cur);

        // Iterate through each tile to form new arrangements
        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) continue; // Skip if the tile has already been used

            used[i] = true; // Mark the tile as used
            backtrack(cur + tiles.charAt(i), tiles, used, set); // Recur with the new arrangement
            used[i] = false; // Backtrack: mark the tile as unused
        }
    }
}
