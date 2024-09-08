/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }


/**
 * Solution class to check if a binary tree is a valid binary search tree.
 */
class Solution {
    /**
     * Checks if a binary tree is a valid binary search tree.
     * 
     * @param root The root of the binary tree.
     * @return True if the binary tree is a valid binary search tree, false otherwise.
     */
    public boolean isValidBST(TreeNode root) {
        /**
         * Calls the helper function isBST with the initial min and max values.
         * 
         * @param root The root of the binary tree.
         * @return True if the binary tree is a valid binary search tree, false otherwise.
         */
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper function to check if a binary tree is a valid binary search tree.
     * 
     * @param root The current node of the binary tree.
     * @param min The minimum value allowed for the current node.
     * @param max The maximum value allowed for the current node.
     * @return True if the binary tree is a valid binary search tree, false otherwise.
     */
    public boolean isBST(TreeNode root, long min, long max) {
        /**
         * If the current node is null, it is a valid binary search tree.
         */
        if (root == null) {
            return true;
        }

        /**
         * If the current node's value is not within the valid range, it is not a valid binary search tree.
         */
        if (root.val <= min || root.val >= max) {
            return false;
        }

        /**
         * Recursively check the left and right subtrees.
         */
        boolean leftTree = isBST(root.left, min, root.val);
        boolean rightTree = isBST(root.right, root.val, max);

        /**
         * If both subtrees are valid binary search trees, return true.
         */
        return leftTree && rightTree;
    }
}




// ---------------------------------------without recursion----------------------------------------------------

class Solution {
    /**
     * Checks if a binary tree is a valid binary search tree.
     * 
     * @param root The root of the binary tree.
     * @return True if the binary tree is a valid binary search tree, false otherwise.
     */
    public boolean isValidBST(TreeNode root) {
        // Initialize a stack to store nodes and their corresponding min and max values
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Long> minStack = new Stack<>();
        minStack.push(Long.MIN_VALUE);
        Stack<Long> maxStack = new Stack<>();
        maxStack.push(Long.MAX_VALUE);
        
        // Iterate over the nodes in the stack
        while (!stack.isEmpty()) {
            // Get the current node and its min and max values
            TreeNode node = stack.pop();
            long min = minStack.pop();
            long max = maxStack.pop();
            
            // If the node is null, skip it
            if (node == null) {
                continue;
            }
            
            // If the node's value is not within the valid range, return false
            if (node.val <= min || node.val >= max) {
                return false;
            }
            
            // Push the right child and its min and max values onto the stack
            stack.push(node.right);
            minStack.push((long) node.val); // Cast node.val to long
            maxStack.push(max);
            
            // Push the left child and its min and max values onto the stack
            stack.push(node.left);
            minStack.push(min);
            maxStack.push((long) node.val); // Cast node.val to long
        }
        
        // If all nodes have been processed and no invalid values were found, return true
        return true;
    }
}
