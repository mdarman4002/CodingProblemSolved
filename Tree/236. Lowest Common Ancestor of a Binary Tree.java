/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        // calling recursively right and left of the tree
        TreeNode leftRotation = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRotation = lowestCommonAncestor(root.right, p, q);
        // apply condition
        if(leftRotation == null){
            return rightRotation;
        }else if(rightRotation == null){
            return leftRotation;
        }else{
            return root;
        }

    }
}
