//142. Linked List Cycle II

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       HashSet<ListNode> hashset = new HashSet<>();
        ListNode curNode = head;
        //int index = 0;
        while(curNode!= null){
            if(hashset.contains(curNode)){
                return curNode;
            }
            hashset.add(curNode);
            //index++;
            curNode = curNode.next;
        }
        return null;
      
    }
}
