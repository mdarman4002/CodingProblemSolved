/**
 * This class provides a solution to find uncommon words from two sentences.
 * A word is considered uncommon if it appears exactly once in the two sentences.
 */
class Solution {
    /**
     * This method takes two sentences as input and returns an array of uncommon words.
     * 
     * @param s1 The first sentence.
     * @param s2 The second sentence.
     * @return An array of uncommon words.
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split the input sentences into arrays of words
        String[] s1Array = s1.split(" ");
        String[] s2Array = s2.split(" ");

        // Create a HashMap to store the frequency of each word
        HashMap<String, Integer> map = new HashMap<>();

        // Count the frequency of each word in the first sentence
        for (String str1 : s1Array) {
            // Use getOrDefault to handle the case where the word is not in the map
            map.put(str1, map.getOrDefault(str1, 0) + 1);
        }

        // Count the frequency of each word in the second sentence
        for (String str2 : s2Array) {
            // Use getOrDefault to handle the case where the word is not in the map
            map.put(str2, map.getOrDefault(str2, 0) + 1);
        }

        // Create a list to store the uncommon words
        ArrayList<String> list = new ArrayList<>();

        // Initialize a counter for the number of uncommon words
        int count = 0;

        // Iterate over the entries in the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // Get the frequency of the current word
            int freq = entry.getValue();

            // Check if the word is uncommon (i.e., its frequency is 1)
            if (freq == 1) {
                // Increment the counter
                count++;

                // Add the word to the list of uncommon words
                list.add(entry.getKey());
            }
        }

        // Create an array to store the uncommon words
        String[] output = new String[count];

        // Initialize an index for the array
        int index = 0;

        // Iterate over the list of uncommon words
        for (String out : list) {
            // Add the word to the array
            output[index++] = out;
        }

        // Return the array of uncommon words
        return output;
    }
}
