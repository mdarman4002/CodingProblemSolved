/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    TreeNode() {}

    // Constructor with value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor with value, left child, and right child
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution class to construct a binary tree from preorder and postorder traversal arrays.
 */
class Solution {
    int n; // Variable to store the length of the preorder array

    /**
     * Constructs a binary tree from given preorder and postorder traversal arrays.
     *
     * @param preorder  an array representing the preorder traversal of the tree
     * @param postorder an array representing the postorder traversal of the tree
     * @return the root of the constructed binary tree
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        n = preorder.length; // Initialize the length of the preorder array
        return construct(preorder, 0, n - 1, postorder, 0, n - 1);
    }

    /**
     * Helper method to recursively construct the binary tree.
     *
     * @param preorder   the preorder array
     * @param presi      the starting index of the current subtree in preorder
     * @param preei      the ending index of the current subtree in preorder
     * @param postorder  the postorder array
     * @param postsi     the starting index of the current subtree in postorder
     * @param postei     the ending index of the current subtree in postorder
     * @return the root of the constructed subtree
     */
    public TreeNode construct(int[] preorder, int presi, int preei, int[] postorder, int postsi, int postei) {
        // Base case: if the current subtree is empty
        if (presi > preei) return null;

        // Create a new tree node with the current root value from preorder
        TreeNode node = new TreeNode(preorder[presi]);

        // If there's only one node, return it
        if (presi == preei) return node;

        // Find the index of the left child's root in the postorder array
        int idx = postsi;
        while (idx <= postei && preorder[presi + 1] != postorder[idx]) {
            idx++;
        }

        // Calculate the size of the left subtree
        int left = idx - postsi + 1;

        // Recursively construct the left and right subtrees
        node.left = construct(preorder, presi + 1, presi + left, postorder, postsi, idx);
        node.right = construct(preorder, presi + left + 1, preei, postorder, idx + 1, postei - 1);

        return node; // Return the constructed subtree
    }
}
