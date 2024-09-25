/**
 * Solution class for longest common prefix calculation
 */
class Solution {
    /**
     * Calculate the longest common prefix for two arrays of integers
     * 
     * @param arr1 first array of integers
     * @param arr2 second array of integers
     * @return the longest common prefix
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Create a Trie instance
        Trie trie = new Trie();
        
        // Add all numbers from arr2 to the Trie
        for (int num : arr2) {
            trie.createTrie(Integer.toString(num));
        }
        
        // Initialize max to store the longest common prefix
        int max = Integer.MIN_VALUE;
        
        // Calculate the longest common prefix for each number in arr1
        for (int num : arr1) {
            max = Math.max(max, trie.longestCommonPrefix(Integer.toString(num)));
        }
        
        return max;
    }
}

/**
 * Node class for Trie data structure
 */
class Node {
    /**
     * Array of child nodes (10 nodes for each digit 0-9)
     */
    Node child[];
    
    /**
     * Node constructor
     */
    Node() {
        child = new Node[10];
    }
}

/**
 * Trie class for longest common prefix calculation
 */
class Trie {
    /**
     * Root node of the Trie
     */
    Node root;
    
    /**
     * Trie constructor
     */
    Trie() {
        root = new Node();
    }
    
    /**
     * Create a Trie for a given number
     * 
     * @param num the number to create the Trie for
     */
    public void createTrie(String num) {
        Node temp = root;
        for (char ch : num.toCharArray()) {
            int index = ch - '0';
            
            // Create a new child node if it doesn't exist
            if (temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            
            temp = temp.child[index];
        }
    }
    
    /**
     * Find the longest common prefix for a given number
     * 
     * @param num the number to find the longest common prefix for
     * @return the longest common prefix
     */
    public int longestCommonPrefix(String num) {
        Node temp = root;
        int count = 0;
        for (char ch : num.toCharArray()) {
            int index = ch - '0';
            
            // If the child node doesn't exist, break the loop
            if (temp.child[index] == null) {
                break;
            }
            
            count++;
            temp = temp.child[index];
        }
        return count;
    }
}
