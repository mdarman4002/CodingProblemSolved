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
    ArrayList<Integer> list = new ArrayList<>();

    // HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                start++;
            } else {
                end--;
            }
        }return false;
        // return findSum(root, k);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
    // public boolean findSum(TreeNode root, int k){
    // if(root == null){
    // return false;
    // }
    // // boolean left = findSum(root.left , k);
    // // boolean right = findSum(root.right , k);

    // //x + y = k --> y = k -x
    // int x = k - root.val;
    // if(set.contains(x)){
    // return true;
    // }else{
    // set.add(root.val);
    // }
    // //return left || right;
    // return findSum(root.left , k) || findSum(root.right , k);

    // }
}
