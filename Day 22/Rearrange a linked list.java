class Solution {

    // Should rearrange given linked list such that all even
    // positioned Nodes are before odd positioned.
    // Returns nothing
    void rearrangeEvenOdd(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return;
    }
}