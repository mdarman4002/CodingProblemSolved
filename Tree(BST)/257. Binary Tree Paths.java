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
// class Solution {
//     public List<String> binaryTreePaths(TreeNode root) {
//        ArrayList<String> path = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        rootToLeaf(root, sb, path);
//        return path;
//     }
//     public void rootToLeaf(TreeNode root, StringBuilder sb, ArrayList<String> path){
//         if(root == null){
//             return;
//         }
//      //   path.add(root.val.toString());
//         sb.append(root.val).toString();
//         if(root.left == null && root.right == null){
//             path.add(sb.append(root.val).toString());
//             return;
//         }
//         rootToLeaf(root.left, sb.append("->"), path);
//         rootToLeaf(root.right, sb.append("->"), path);
//         //sb.deleteCharAt(sb.length()-1);
//         sb.substring(0, sb.length() - 1);
//     }
// }

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> path = new ArrayList<>();
        if (root != null) {
            rootToLeaf(root, new StringBuilder(), path);
        }
        return path;
    }

    public void rootToLeaf(TreeNode root, StringBuilder sb, ArrayList<String> path) {
        if (root == null) {
            return;
        }

        int len = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            path.add(sb.toString());
        } else {
            sb.append("->");
            rootToLeaf(root.left, sb, path);
            rootToLeaf(root.right, sb, path);
        }

       sb.setLength(len);
    }
}
