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
    public TreeNode reverseOddLevels(TreeNode root) {
       
        reverseOdd(root.left, root.right, true);
        return root;
        
    }
    public void reverseOdd(TreeNode left, TreeNode right,boolean isOddLevel ){
        if(left == null || right == null ) {
            return;
        }
        
        if(isOddLevel){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        reverseOdd(left.left, right.right, !isOddLevel);
        reverseOdd(left.right, right.left, !isOddLevel);
        
    }
}
