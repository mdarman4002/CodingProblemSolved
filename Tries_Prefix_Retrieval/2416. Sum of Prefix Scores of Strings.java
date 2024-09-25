/**
 * Solution class for prefix score calculation
 */
class Solution {
    /**
     * Calculate prefix scores for a given array of words
     * 
     * @param words array of words
     * @return array of prefix scores
     */
    public int[] sumPrefixScores(String[] words) {
        // Create a Trie instance
        Trie trie = new Trie();
        
        // Initialize an array to store prefix scores
        int count[] = new int[words.length];

        // Add all words to the Trie
        for(String word: words){
            trie.addWord(word);
        }
        
        // Calculate prefix scores for each word
        int index = 0;
        for(String word: words) {
            count[index++] = trie.findPrefixCount(word);
        }
        
        return count;
    }
}

/**
 * Node class for Trie data structure
 */
class Node{
    /**
     * Array of child nodes (26 nodes for each lowercase letter)
     */
    Node child[];
    
    /**
     * Count of words that pass through this node
     */
    int count;
    
    /**
     * Node constructor
     */
    Node(){
        child = new Node[26];
        count = 0;
    }
}

/**
 * Trie class for prefix score calculation
 */
class Trie{
    /**
     * Root node of the Trie
     */
    Node root;
    
    /**
     * Trie constructor
     */
    Trie(){
        root = new Node();
    }
    
    /**
     * Add a word to the Trie
     * 
     * @param word the word to add
     */
    public void addWord(String word){
        Node temp = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            
            // Create a new child node if it doesn't exist
            if(temp.child[index] == null){
                temp.child[index] = new Node();
            }
            
            // Increment the count of words that pass through this node
            temp.child[index].count++;
            temp = temp.child[index];
        }
    }
    
    /**
     * Find the prefix count for a given word
     * 
     * @param word the word to find the prefix count for
     * @return the prefix count
     */
    public int findPrefixCount(String word){
        Node temp = root;
        int resultCount = 0;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            
            // Add the count of words that pass through this node to the result
            resultCount += temp.child[index].count;
            temp = temp.child[index];
        }
        return resultCount;
    }
}
