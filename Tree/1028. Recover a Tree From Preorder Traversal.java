/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * The Solution class provides a method to recover a binary tree from a 
 * preorder traversal string that encodes the tree structure.
 */
class Solution {
    private int index; // Current index in the traversal string
    private int n;     // Length of the traversal string

    /**
     * Recovers a binary tree from its preorder traversal string.
     *
     * @param traversal A string representing the preorder traversal of a binary tree,
     *                  where each node's depth is indicated by the number of dashes
     *                  before the node's value.
     * @return The root of the recovered binary tree.
     */
    public TreeNode recoverFromPreorder(String traversal) {
        index = 0; // Initialize the index
        n = traversal.length(); // Get the length of the traversal string
        return dfs(traversal, 0); // Start the depth-first search
    }

    /**
     * Performs a depth-first search to construct the binary tree from the traversal string.
     *
     * @param traversal The preorder traversal string.
     * @param depth The current depth in the tree, used to match the number of dashes.
     * @return The TreeNode corresponding to the current position in the traversal string.
     */
    public TreeNode dfs(String traversal, int depth) {
        if (index >= n) return null; // Base case: if the index exceeds the string length, return null.

        int count = 0; // Count the number of dashes
        int temp = index; // Temporary index to count dashes
        while (temp < n && !Character.isDigit(traversal.charAt(temp))) {
            count++; // Increment count for each dash
            temp++;
        }

        // If the number of dashes does not match the expected depth, return null
        if (count != depth) return null;

        index = temp; // Update the index to the first digit
        int val = 0; // Initialize the value of the current node
        while (index < n && Character.isDigit(traversal.charAt(index))) {
            val = val * 10 + traversal.charAt(index) - '0'; // Build the integer value
            index++;
        }

        // Create a new TreeNode with the extracted value
        TreeNode node = new TreeNode(val);
        // Recursively construct the left and right subtrees
        node.left = dfs(traversal, depth + 1);
        node.right = dfs(traversal, depth + 1);
        return node; // Return the constructed node
    }
}

/**
 * Example usage:
 * Solution solution = new Solution();
 * TreeNode root = solution.recoverFromPreorder("1-2--3--4-5--6--7");
 */
