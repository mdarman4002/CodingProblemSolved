/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Checks whether a linked list is a palindrome.
     * 
     * @param head the head of the linked list
     * @return true if the linked list is a palindrome, false otherwise
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            // base case: empty list or single-element list is a palindrome
            return true;
        }
        
        // find the middle node of the linked list
        ListNode mid = findMidNode(head);
        
        // reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // set up pointers for the two halves of the list
        ListNode right = prev; // points to the reversed second half
        ListNode left = head; // points to the first half
        
        // compare the two halves element by element
        while(right != null){
            if(right.val != left.val){
                // if the values don't match, return false
                return false;
            }
            right = right.next;
            left = left.next;
        }
        
        // if we reach the end of the loop without finding a mismatch, return true
        return true;
    }
    
    /**
     * Finds the middle node of a linked list using the slow and fast pointer technique.
     * 
     * @param head the head of the linked list
     * @return the middle node of the linked list
     */
    public ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}



           //     using stack

        // ListNode p1 = head;
        // Stack<Integer> stack = new Stack<>();
        // // push into the stack
        // while (p1 != null) {
        //     stack.push(p1.val);
        //     p1 = p1.next;
        // }
        // // pop from the stack and compare the value
        // ListNode p2 = head;
        // while(p2 != null){
        //     int popval = stack.pop();
        //     int curval = p2.val;
        //     if(popval != curval){
        //         return false;
        //     }
        //     p2 = p2.next;
        // }return true;
    //}
//}
