class Solution {
    public char findKthBit(int n, int k) {
        int len = (1 << n) - 1;  // Calculate 2^n - 1
        return find(n, len, k);
    }

    public char find(int n, int len, int k) {
        if (k == 1) {
            return '0';  // Base case
        }
        
        int half = (1 << (n - 1)) - 1;  // Calculate the length of the first half
        int middle = half + 1;          // Middle position in the string

        // Check if k is at the last position or the middle position
        if (k == len || k == middle) {
            return '1';
        } else if (k < middle) {
            return find(n - 1, half, k);  // Search in the first half
        } else {
            // Search in the second half and invert the result
            char ans = find(n - 1, half, len - k + 1);
            return (ans == '0') ? '1' : '0';  // Invert the bit
        }
    }
}
