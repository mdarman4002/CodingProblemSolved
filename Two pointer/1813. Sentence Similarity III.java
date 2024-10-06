/**
 * Class Solution
 * 
 * This class contains a method to check if two sentences are similar.
 */
class Solution {
    /**
     * Method areSentencesSimilar
     * 
     * This method checks if two sentences are similar.
     * Two sentences are similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal.
     * 
     * @param sentence1 the first sentence
     * @param sentence2 the second sentence
     * @return true if the sentences are similar, false otherwise
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // If sentence1 is longer than sentence2, swap them to ensure sentence1 is the shorter sentence
        if(sentence1.length() > sentence2.length()) return areSentencesSimilar(sentence2, sentence1);

        // Split the sentences into arrays of words
        String word1[] = sentence1.split(" ");
        String word2[] = sentence2.split(" ");

        // Initialize pointers to the start and end of the sentences
        int start = 0;
        int end1 = word1.length-1;
        int end2 = word2.length-1;

        // Compare words from the start of the sentences
        while(start <= end1 && word1[start].equals(word2[start])){
            start++;
        }

        // Compare words from the end of the sentences
        while(start <= end1 && word1[end1].equals(word2[end2])){
            end1--;
            end2--;
        }

        // If the pointers have crossed each other, the sentences are similar
        if(start > end1){
            return true;
        }

        // If the pointers have not crossed each other, the sentences are not similar
        return false;
    }
}
