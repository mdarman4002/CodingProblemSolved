/**
 * Definition for a Node.
 */
class Node {
    /**
     * The value of the node.
     */
    public int val;
    /**
     * The list of child nodes.
     */
    public List<Node> children;

    /**
     * Default constructor.
     */
    public Node() {}

    /**
     * Constructor with value.
     * 
     * @param _val The value of the node.
     */
    public Node(int _val) {
        val = _val;
    }

    /**
     * Constructor with value and children.
     * 
     * @param _val The value of the node.
     * @param _children The list of child nodes.
     */
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

/**
 * This class provides a solution for the problem of traversing a tree in post-order.
 */
class Solution {
    /**
     * This method performs a post-order traversal of the tree and returns the result as a list.
     * 
     * @param root The root node of the tree.
     * @return A list of node values in post-order.
     */
    public List<Integer> postorder(Node root) {
        /**
         * The list to store the node values in post-order.
         */
        ArrayList<Integer> output = new ArrayList<>();
        /**
         * Perform the depth-first search in post-order.
         */
        postOrderDfs(root, output);
        return output;
    }

    /**
     * This method performs a depth-first search of the tree in post-order.
     * 
     * @param root The current node being visited.
     * @param output The list of node values in post-order.
     */
    public void postOrderDfs(Node root, ArrayList<Integer> output) {
        /**
         * Base case: if the node is null, return immediately.
         */
        if (root == null) {
            return;
        }
        /**
         * Recursively visit each child node.
         */
        for (Node child : root.children) {
            postOrderDfs(child, output);
        }
        /**
         * Add the current node's value to the output list.
         */
        output.add(root.val);
    }
}
