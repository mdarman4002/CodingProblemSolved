
class Solution {
    public int minSwaps(String s) {
        int open = 0; // Count of unmatched '['
        int close = 0; // Count of unmatched ']'
        
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                open++;
            } else if (ch == ']') {
                if (open > 0) {
                    open--; // Match with an unmatched '['
                } else {
                    close++; // Count unmatched ']'
                }
            }
        }
        
        // The number of swaps needed is the ceiling of (unmatched '[' + unmatched ']') / 2
        // We can also simply return (close + 1) / 2 to account for rounding up
        return (close + 1) / 2; // Each swap fixes two unmatched ']' if any
    }
}
