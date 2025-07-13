import java.util.Arrays;

/**
 * The Solution class provides a method to match players with trainers based on their capacities.
 */
class Solution {
    
    /**
     * Matches players with trainers based on their capacities.
     * 
     * This method takes two arrays: one representing the capacities of players and the other representing
     * the capacities of trainers. It sorts both arrays and uses a two-pointer technique to find the maximum
     * number of matches where a trainer can train a player if the trainer's capacity is greater than or equal
     * to the player's capacity.
     * 
     * @param players An array of integers representing the capacities of players.
     * @param trainers An array of integers representing the capacities of trainers.
     * @return The maximum number of players that can be matched with trainers.
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Sort both players and trainers arrays
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int p = players.length; // Number of players
        int t = trainers.length; // Number of trainers

        int result = 0; // Counter for matches
        int i_p = 0; // Pointer for players
        int j_t = 0; // Pointer for trainers
        
        // Use two pointers to find matches
        while (i_p < p && j_t < t) {
            int player = players[i_p]; // Current player's capacity
            int trainer = trainers[j_t]; // Current trainer's capacity
            
            // If the current trainer can train the current player
            if (trainer >= player) {
                result++; // Increment the match count
                i_p++; // Move to the next player
            }
            // Move to the next trainer in either case
            j_t++;
        }
        
        return result; // Return the total number of matches
    }
}
