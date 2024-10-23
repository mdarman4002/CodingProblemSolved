/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution class to replace values in a binary tree.
 */
class Solution {
    /**
     * Replaces each node's value in the binary tree with the sum of the values of its siblings
     * at the same level, and sets the root's value to 0.
     *
     * @param root The root node of the binary tree.
     * @return The root node of the modified binary tree.
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        // Queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // List to store the sum of values at each level
        ArrayList<Integer> listsum = new ArrayList<>();
        
        // Start with the root node
        queue.offer(root);
        
        // First pass: Calculate the sum of values at each level
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;
                // Add child nodes to the queue
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            // Store the sum for the current level
            listsum.add(sum);
        }
        
        // Set the root's value to 0
        root.val = 0;
        queue.offer(root);
        int level = 0;
        
        // Second pass: Replace the values of nodes based on sibling sums
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int sum = 0;

                // Calculate the sum of the values of the node's children
                if (node.left != null) {
                    sum += node.left.val;
                }
                if (node.right != null) {
                    sum += node.right.val;
                }
                
                // Replace the left child's value
                if (node.left != null) {
                    node.left.val = listsum.get(level + 1) - sum;
                    queue.offer(node.left);
                }
                
                // Replace the right child's value
                if (node.right != null) {
                    node.right.val = listsum.get(level + 1) - sum;
                    queue.offer(node.right);
                }
            }
            level++;
        }
        
        return root;
    }
}
