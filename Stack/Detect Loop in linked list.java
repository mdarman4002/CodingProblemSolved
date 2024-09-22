
// User function template for JAVA

/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        if(head == null){
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while(temp != null){
            if(stack.contains(temp)){
                return true;
            }
            stack.push(temp);
            temp = temp.next;
        }
        // Node slow = head;
        // Node fast = head;
        
        // while(fast != null && slow != null && fast.next != null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        //     if(slow == fast){
        //         return true;
        //     }
        // }
        return false;
    }
}
