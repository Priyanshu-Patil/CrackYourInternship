class Solution {
    Node divide(Node head) {
        Node oddNode = new Node(0);
        Node evenNode = new Node(0);
        Node evenCurr = evenNode;
        Node oddCurr = oddNode;
        Node curr = head;
        
        while (curr != null) {
            if (curr.data % 2 == 0) {
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
            } else {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
            }
            curr = curr.next;
        }
        
        // Terminate both lists
        evenCurr.next = null;
        oddCurr.next = null;

        // Combine even and odd lists
        evenCurr.next = oddNode.next;
        return evenNode.next;
    }
}