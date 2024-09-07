/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    /**
     * Checks if the linked list is a subpath of the binary tree.
     * 
     * @param head the head of the linked list
     * @param root the root of the binary tree
     * @return true if the linked list is a subpath of the binary tree, false otherwise
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (isIdentical(head, root)) {
            return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    /**
     * Checks if the linked list is identical to a path in the binary tree.
     * 
     * @param head the head of the linked list
     * @param root the current node in the binary tree
     * @return true if the linked list is identical to a path in the binary tree, false otherwise
     */
    public boolean isIdentical(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null || head.val != root.val) {
            return false;
        }
        
        // Check if the rest of the linked list matches either the left or right subtree
        return isIdentical(head.next, root.left) || isIdentical(head.next, root.right);
    }
}
