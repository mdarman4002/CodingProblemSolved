 in Java, String.replace(char oldChar, char newChar) replaces all 
occurrences of oldChar with newChar in the entire string.

class Solution {
    public int minMaxDifference(int num) {
        String str = Integer.toString(num);

        // For max: replace first non-'9' digit with '9'
        char toReplaceMax = ' ';
        for (char c : str.toCharArray()) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        String maxStr = str;
        if (toReplaceMax != ' ') {
            maxStr = str.replace(toReplaceMax, '9');
        }

        // For min: replace first digit (even if repeated) with '0'
        char toReplaceMin = str.charAt(0);
        String minStr = str.replace(toReplaceMin, '0');

        int maxNum = Integer.parseInt(maxStr);
        int minNum = Integer.parseInt(minStr);
        return maxNum - minNum;
    }
}
