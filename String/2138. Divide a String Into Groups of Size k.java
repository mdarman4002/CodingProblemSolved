class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int numSegments = (n + k - 1) / k; // Calculate the number of segments needed
        StringBuilder[] result = new StringBuilder[numSegments];
        int index = 0;

        for (int i = 0; i < n; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j < n) {
                    sb.append(s.charAt(j)); // Append the character at j
                }
            }
            // Fill the remaining characters with 'fill' if necessary
            while (sb.length() < k) {
                sb.append(fill);
            }
            result[index++] = sb;
        }

        // Convert StringBuilder array to String array
        String[] finalResult = new String[numSegments];
        for (int res = 0; res < numSegments; res++) {
            finalResult[res] = result[res].toString();
        }
        return finalResult;
    }
}
