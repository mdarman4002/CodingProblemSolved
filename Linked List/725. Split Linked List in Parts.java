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
 * Solution class to split a singly-linked list into k parts.
 */
class Solution {
    /**
     * Splits a singly-linked list into k parts.
     * 
     * @param head The head of the singly-linked list.
     * @param k The number of parts to split the list into.
     * @return An array of ListNode, where each ListNode is the head of a part.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Initialize a pointer to the head of the list
        ListNode cur = head;
        
        // Calculate the size of the list
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        
        // Initialize an array to store the heads of the parts
        ListNode[] res = new ListNode[k];
        
        // Reset the pointer to the head of the list
        cur = head;
        
        // Calculate the average length of each part
        int avg = size / k;
        
        // Calculate the number of extra nodes that need to be distributed among the parts
        int extra = size % k;
        
        // Iterate over the parts
        for (int i = 0; i < k; i++) {
            // If the list is exhausted, break the loop
            if (cur == null) break;
            
            // Initialize the head of the current part
            ListNode curHead = cur;
            
            // Initialize a pointer to the previous node in the current part
            ListNode prev = null;
            
            // Initialize the length of the current part
            int len = 0;
            
            // Iterate over the nodes in the current part
            while (cur != null && len < avg) {
                // Update the previous node
                prev = cur;
                
                // Move to the next node
                cur = cur.next;
                
                // Increment the length of the current part
                len++;
            }
            
            // If there are extra nodes, add one to the current part
            if (extra > 0) {
                // Update the previous node
                prev = cur;
                
                // Move to the next node
                cur = cur.next;
                
                // Decrement the number of extra nodes
                extra--;
            }
            
            // Set the next pointer of the last node in the current part to null
            prev.next = null;
            
            // Store the head of the current part in the result array
            res[i] = curHead;
        }
        
        // Return the result array
        return res;
    }
}
