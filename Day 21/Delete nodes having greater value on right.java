class Solution {
    Node compute(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        
        Node current = head;
        Node maxNode = head;
        Node temp;
        
        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                temp = current.next;
                current.next = temp.next;
            } else {
                current = current.next;
                maxNode = current;
            }
        }
        
        curr = head;
        prev = null;
        
        while(curr != null) {
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
        }
        
        head = prev;
        
        return head;
    }
}