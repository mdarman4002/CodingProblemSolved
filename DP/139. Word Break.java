/**
 * A solution class for the word break problem.
 */
class Solution {
    /**
     * The root node of the Trie data structure.
     */
    Node root = new Node();

    /**
     * Checks if a given string can be segmented into words from a dictionary.
     * 
     * @param s The input string.
     * @param wordDict The dictionary of words.
     * @return True if the string can be segmented, false otherwise.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // Insert all words from the dictionary into the Trie.
        for (String word : wordDict) {
            insert(word);
        }

        // Create a dynamic programming array to store whether each prefix of the string can be segmented.
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // Iterate over the string and check for each prefix whether it can be segmented into words from the dictionary.
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && search(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // Return whether the entire string can be segmented into words from the dictionary.
        return dp[s.length()];
    }
 // public boolean wordbreak(String s){
    //     if(s.length() == 0){
    //         return true;
    //     }
    //     for(int i = 1; i <= s.length(); i++){
    //         if(search(s.substring(0, i)) && wordbreak(s.substring(i))){
    //             return true;
    //         }
    //     }return false;
    // }

    /**
     * Searches for a word in the Trie.
     * 
     * @param word The word to be searched.
     * @return True if the word is found, false otherwise.
     */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.eow == true;
    }

    /**
     * Inserts a word into the Trie.
     * 
     * @param word The word to be inserted.
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.eow = true;
    }

    /**
     * A node in the Trie data structure.
     */
    class Node {
        // An array of child nodes, one for each letter of the alphabet.
        Node children[] = new Node[26];

        // A boolean indicating whether this node represents the end of a word.
        boolean eow = false;

        /**
         * Constructor to initialize a node.
         */
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
}
