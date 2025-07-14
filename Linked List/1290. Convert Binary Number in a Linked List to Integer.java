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
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder("");
        while(node != null){
            int val = node.val;
            sb.append(val);
            node = node.next;
        }
        int num = Integer.parseInt(sb.toString(),2);
        return num;
    }
}
