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
    public int countNodes(TreeNode root) {
        int  count;
        if(root == null){
            return 0;
        }else{
            int leftTree = countNodes(root.left);
            int rightTree = countNodes(root.right);

            count= leftTree + rightTree + 1;

        }
        return count;
    }
}
