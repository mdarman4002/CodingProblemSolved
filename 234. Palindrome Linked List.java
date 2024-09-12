/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode() {}
 *   ListNode(int val) { this.val = val; }
 *   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
  /**
   * Checks if a singly-linked list is a palindrome.
   *
   * @param head The head node of the singly-linked list.
   * @return True if the list is a palindrome, false otherwise.
   *
   * @throws IllegalArgumentException if the head node is null.
   */
  public boolean isPalindrome(ListNode head) {
    ListNode p1 = head;
    Stack<Integer> stack = new Stack<>();
    while (p1 != null) {
      stack.push(p1.val);
      p1 = p1.next;
    }

    ListNode p2 = head;
    while (p2 != null) {
      int val1 = p2.val;
      int val2 = stack.pop();
      if (val1 != val2) {
        return false;
      }
      p2 = p2.next;
    }
    return true;
  }
}
-------------------------------Documentation--------------------------
**Explanation:**

- This function determines if a singly-linked list is a palindrome (reads same backward as forward).

**Arguments:**

- head: The head node of the list.

**Return Value:**

- true if palindrome, false otherwise.

**Algorithm:**

1. Iterates through list, pushing node values onto a stack.
2. Iterates again, comparing values with popped values from stack.
   - Mismatch means not a palindrome (return false).
3. If loop completes, all values match (return true).

**Time Complexity:** O(n) - iterates twice (n nodes).
**Space Complexity:** O(n) - uses a stack (worst case: holds all n values).
