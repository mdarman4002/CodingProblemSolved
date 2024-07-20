/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// class Solution {
//     public int diameterOfBinaryTree(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int dialeft = diameterOfBinaryTree(root.left);
//         int diaright = diameterOfBinaryTree(root.right);

//         int dia = height(root.left) + height(root.right) ;

//         int output = Math.max(dia, Math.max(dialeft, diaright));
//         return output;

//     }

//     public int height(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
//         return Math.max(leftHeight, rightHeight) + 1;
//     }
// }

class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
