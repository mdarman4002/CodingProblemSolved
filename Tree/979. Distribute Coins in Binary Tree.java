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
 */
class Solution {
    private int moves;
    
    public int distributeCoins(TreeNode root) {
        moves = 0;
        postorder(root);
        return moves;
    }
    
    private int postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftExcess = postorder(node.left);
        int rightExcess = postorder(node.right);
        
        // Calculate total moves needed for current node
        moves += Math.abs(leftExcess) + Math.abs(rightExcess);
        
        // Return the excess coins at this node
        return node.val + leftExcess + rightExcess - 1;
    }
}
