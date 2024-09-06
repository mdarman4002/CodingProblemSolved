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
 * This class provides a solution to modify a linked list by removing nodes that match the elements in the given array.
 */
class Solution {
    /**
     * This method takes an array of integers and a linked list as input, and returns the modified linked list.
     * The modification involves removing nodes from the linked list that match the elements in the array.
     * 
     * @param nums The array of integers to match against the linked list nodes.
     * @param head The head node of the linked list to be modified.
     * @return The modified linked list with nodes removed that match the array elements.
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a HashSet to store the array elements for efficient lookups
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }

        // Create a dummy node to simplify edge cases and initialize pointers
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // Previous node pointer
        ListNode cur = head; // Current node pointer

        // Traverse the linked list and remove nodes that match the array elements
        while (cur != null) {
            if (set.contains(cur.val)) {
                // Remove the current node by updating the previous node's next pointer
                prev.next = cur.next;
            } else {
                // Move the previous node pointer to the current node
                prev = cur;
            }
            // Move the current node pointer to the next node
            cur = cur.next;
        }

        // Return the modified linked list (excluding the dummy node)
        return dummy.next;
    }
}
