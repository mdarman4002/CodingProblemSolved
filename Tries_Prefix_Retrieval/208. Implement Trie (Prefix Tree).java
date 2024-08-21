/**
 * A Trie data structure, also known as a prefix tree, is a tree-like data structure that is often used to store a dynamic set or associative array where the keys are usually strings.
 */
class Trie {
    /**
     * An array of 26 Trie nodes, one for each letter of the alphabet.
     */
    Trie children[];

    /**
     * A boolean indicating whether the current node is the end of a word.
     */
    boolean eow;

    /**
     * Constructor to initialize a new Trie node.
     */
    public Trie() {
        children = new Trie[26];
        eow = false;
    }

    /**
     * Inserts a word into the Trie.
     * 
     * @param word The word to be inserted.
     */
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    /**
     * Searches for a word in the Trie.
     * 
     * @param word The word to be searched.
     * @return True if the word is found, false otherwise.
     */
    public boolean search(String word) {
        Trie cur = this;
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
     * Checks if there is any word in the Trie that starts with the given prefix.
     * 
     * @param prefix The prefix to be searched.
     * @return True if there is a word that starts with the prefix, false otherwise.
     */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
