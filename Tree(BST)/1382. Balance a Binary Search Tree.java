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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        int start = 0, end = list.size()-1;
        TreeNode tree = bst(root,start, end, list);
        return tree;
    }
    public TreeNode bst(TreeNode root, int start, int end, ArrayList list){
        if(start > end){
            return null;
        }
        int mid = (start + end )/2;
       
        TreeNode newTree = new TreeNode((int)list.get(mid));
        newTree.left = bst(root, start, mid-1,list);
        newTree.right = bst(root, mid+1, end, list);
        return newTree;
    }
    public void inorder(TreeNode root, ArrayList list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right, list);

    }
}
