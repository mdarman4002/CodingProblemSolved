class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int aCount[] = new int[n];
        int bCount[] = new int[n];

        // Count the number of 'b's to the left of each index
        for (int i = 1; i < n; i++) {
            char prevChar = s.charAt(i - 1);
            bCount[i] = bCount[i - 1];
            if (prevChar == 'b') {
                bCount[i] += 1;
            }
        }

        // Count the number of 'a's to the right of each index
        for (int i = n - 2; i >= 0; i--) {
            char prevChar = s.charAt(i + 1);
            aCount[i] = aCount[i + 1];
            if (prevChar == 'a') {
                aCount[i] += 1;
            }
        }

        // Find the minimum number of deletions required to make the string balanced
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, aCount[i] + bCount[i]);
        }

        return min;
    }
}

// Time Complexity:

// O(n), where n is the length of the input string.
// Space Complexity:

// O(n), where n is the length of the input string.
