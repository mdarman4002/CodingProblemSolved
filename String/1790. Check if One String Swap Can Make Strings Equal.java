
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if (s1.equals(s2)) {
            return true;
        }

        int[] diffIndices = new int[2];
        int count = 0; // To count the number of differing characters

        // Loop through the characters of both strings
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // If we find more than 2 differences, return false
                if (count >= 2) {
                    return false;
                }
                diffIndices[count] = i; // Store the index of the difference
                count++;
            }
        }

        // If there are exactly two differences, check if swapping makes them equal
        if (count == 2) {
            return s1.charAt(diffIndices[0]) == s2.charAt(diffIndices[1]) &&
                   s1.charAt(diffIndices[1]) == s2.charAt(diffIndices[0]);
        }

        // If there are not exactly two differences, return false
        return false;
    }
}
