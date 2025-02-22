import java.util.HashSet;

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
 * The FindElements class is designed to restore a binary tree that has been corrupted
 * and allows for searching for specific values in the tree.
 */
class FindElements {
    private HashSet<Integer> set;

    /**
     * Constructs a FindElements object and initializes the set of values
     * by performing a depth-first search (DFS) on the given binary tree.
     *
     * @param root The root of the binary tree that has been corrupted.
     */
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        dfs(root, 0);
    }

    /**
     * Searches for a target value in the restored binary tree.
     *
     * @param target The value to search for in the tree.
     * @return true if the target value exists in the tree; false otherwise.
     */
    public boolean find(int target) {
        return set.contains(target);
    }

    /**
     * Performs a depth-first search (DFS) on the binary tree to restore
     * the values of the nodes based on their positions.
     *
     * @param root The current node being processed.
     * @param val The value to assign to the current node.
     */
    private void dfs(TreeNode root, int val) {
        if (root == null) return; // Base case: if the node is null, return.
        root.val = val;           // Assign the calculated value to the current node.
        set.add(val);             // Add the value to the set for quick lookup.
        dfs(root.left, 2 * val + 1); // Recursively process the left child.
        dfs(root.right, 2 * val + 2); // Recursively process the right child.
    }
}

/**
 * Example usage:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
