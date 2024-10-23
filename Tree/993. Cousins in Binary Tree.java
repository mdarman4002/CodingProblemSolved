/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val; // Value of the node
    TreeNode left; // Reference to the left child
    TreeNode right; // Reference to the right child

    // Default constructor
    TreeNode() {}

    // Constructor that initializes the node with a value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor that initializes the node with a value, left child, and right child
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution class to determine if two nodes in a binary tree are cousins.
 */
class Solution {
    /**
     * Method to check if two nodes with values x and y are cousins in the binary tree.
     *
     * @param root The root of the binary tree.
     * @param x The value of the first node.
     * @param y The value of the second node.
     * @return true if x and y are cousins, false otherwise.
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        // Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Continue until there are no more nodes to process
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level
            boolean xFound = false; // Flag to check if x is found
            boolean yFound = false; // Flag to check if y is found
            
            // Process each node at the current level
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll(); // Get the current node
                
                // Check the left child
                if (curNode.left != null) {
                    queue.add(curNode.left); // Add left child to the queue
                    if (curNode.left.val == x) xFound = true; // Check if left child is x
                    if (curNode.left.val == y) yFound = true; // Check if left child is y
                }
                
                // Check the right child
                if (curNode.right != null) {
                    queue.add(curNode.right); // Add right child to the queue
                    if (curNode.right.val == x) xFound = true; // Check if right child is x
                    if (curNode.right.val == y) yFound = true; // Check if right child is y
                }
                
                // Check if x and y are siblings
                if ((curNode.left != null && curNode.left.val == x && curNode.right != null && curNode.right.val == y) ||
                    (curNode.left != null && curNode.left.val == y && curNode.right != null && curNode.right.val == x)) {
                    return false; // They are siblings, so return false
                }
            }
            
            // If both x and y were found at the same level but not as siblings, they are cousins
            if (xFound && yFound) {
                return true; // Return true if both are found
            }
        }
        return false; // Return false if we finish the loop and haven't found cousins
    }
}
