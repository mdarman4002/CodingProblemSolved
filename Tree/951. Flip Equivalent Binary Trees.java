/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val; // Value of the node
    TreeNode left; // Left child
    TreeNode right; // Right child

    // Default constructor
    TreeNode() {}

    // Constructor with value
    TreeNode(int val) { 
        this.val = val; 
    }

    // Constructor with value and children
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution class to determine if two binary trees are flip equivalent.
 */
class Solution {
    /**
     * Checks if two binary trees are flip equivalent.
     * 
     * @param root1 The root of the first binary tree.
     * @param root2 The root of the second binary tree.
     * @return true if the trees are flip equivalent, false otherwise.
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // If both nodes are null, they are equivalent
        if ((root1 == null) && (root2 == null)){
            return true;
        }
        // If one of the nodes is null, they are not equivalent
        if ((root1 == null) || (root2 == null)){
            return false;
        }
        // If the values of the nodes are different, they are not equivalent
        if(root1.val != root2.val){
            return false;
        }
        
        // Check if the left and right subtrees are equivalent in both orientations
        boolean isSame;
        // Check if both left-left and right-right subtrees are equivalent
        isSame = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        
        // If they are the same, return true
        if(isSame){
            return true;
        }
        
        // Otherwise, check if left-right and right-left subtrees are equivalent
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
