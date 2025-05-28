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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // postOrder(root, list);
        // return list;
        if (root == null) {
            return list;
        } else {

            for (Integer val : postorderTraversal(root.left)) {
                list.add(val);
            }
            for (Integer val : postorderTraversal(root.right)) {
                list.add(val);
            }
            list.add(root.val);
        }
        return list;
    }
}


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        return postorder(root , list);
    }
    public List<Integer> postorder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return list;
        }
        postorder(root.left, list);
        postorder(root.right,list);
        list.add(root.val);
        return list;

    }
}
