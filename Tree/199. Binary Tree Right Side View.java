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
    public List<Integer> rightSideView(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        } else {

            queue.add(root);
            while (!queue.isEmpty()) {
                int qsize = queue.size();
                for (int i = 0; i < qsize; i++) {
                    TreeNode curNode = queue.remove();
                    if (i == qsize - 1) {
                        list.add(curNode.val);
                    }
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
                }

            }return list;
        }
    }
}
