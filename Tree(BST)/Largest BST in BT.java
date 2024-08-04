// Definition for a binary tree node
class Node { 
    int data; 
    Node left, right; 

    public Node(int d) { 
        data = d; 
        left = right = null; 
    } 
}

  //     10
  //    /  \
  //   5    15
  //  / \   / \
  // 1   8 12  30


class Solution {
    private static int maxBst = 0;

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        maxBst = 0;  // Reset for each new call
        largestBST(root);
        return maxBst;
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static Info largestBST(Node root) {
        if (root == null) {
            // Return a default Info object for null nodes
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Recur for the left and right subtrees
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        // Current subtree size
        int size = leftInfo.size + rightInfo.size + 1;
        
        // Find the min and max in the current subtree
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Check if the current subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            // Update maxBst if the current subtree is larger
            maxBst = Math.max(maxBst, size);
            return new Info(true, size, min, max);
        }

        // If not a BST, return false
        return new Info(false, size, min, max);
    }
}
