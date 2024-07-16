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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = LCA(root, startValue, destValue);
        StringBuilder sourceToLca = new StringBuilder();
        StringBuilder LcaToDest = new StringBuilder();
        findPath(lca, startValue, sourceToLca);
        findPath(lca, destValue, LcaToDest);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < sourceToLca.length(); i++){
            result.append("U");
        }
        //result.append(sourceToLca);
        result.append(LcaToDest);
        return result.toString();
    }
    public TreeNode LCA(TreeNode root, int p, int q){
        if(root == null || root.val == p || root.val == q){
            return root;
        }
        TreeNode leftChild = LCA(root.left, p, q);
        TreeNode rightChild = LCA(root.right, p, q);
        if(leftChild == null){
            return rightChild;
        }else if(rightChild == null){
            return leftChild;
        }else{
            return root;
        }
    }
    public boolean findPath(TreeNode root, int target, StringBuilder path){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        path.append("L");
        if(findPath(root.left, target, path)){
            return true;
        }//backtracking
        path.setLength(path.length()-1);


        path.append("R");
        if(findPath(root.right, target, path)){
            return true;
        }//backtracking
        path.setLength(path.length()-1);
        return false;
    }
}
