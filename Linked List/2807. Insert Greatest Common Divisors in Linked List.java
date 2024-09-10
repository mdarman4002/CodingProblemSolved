class Solution {
    /**
     * Inserts the greatest common divisors between each pair of nodes in the linked list.
     * 
     * @param head the head of the linked list
     * @return the modified linked list with GCD nodes inserted
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Create a new result list with a dummy node
        ListNode result = new ListNode(0);
        ListNode last = result; // Maintain a pointer to the last node of the result list

        ListNode current = head;
        while (current != null && current.next != null) {
            // Calculate the GCD of the current node and the next node
            int f = current.val;
            int s = current.next.val;
            int gcdvalue = gcdCalled(f, s);

            // Create new nodes for the current value, GCD, and next value
            ListNode gcd = new ListNode(gcdvalue);
            ListNode firstNode = new ListNode(f);

            // Insert the new nodes into the result list
            last.next = firstNode;
            firstNode.next = gcd;
            gcd.next = current.next;

            // Update the last node pointer
            last = gcd;
            current = current.next;
        }

        // Add the last node to the result list
        ListNode lastNode = new ListNode(current.val);
        last.next = lastNode;
        last = lastNode;

        return result.next;
    }

    /**
     * Calculates the greatest common divisor of two numbers using the Euclidean algorithm.
     * 
     * @param n1 the first number
     * @param n2 the second number
     * @return the GCD of the two numbers
     */
    public int gcdCalled(int n1, int n2) {
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);

        int rem = 1;
        while (rem != 0) {
            rem = max % min;
            if (rem == 0) {
                return min;
            }
            max = min;
            min = rem;
        }
        return 1;
    }
}
