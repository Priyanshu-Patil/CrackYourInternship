class Solution {

   public Node sort(Node head) {
       return separate(head);
   }

   public Node separate(Node head) {
       Node head2 = null, tail2 = null, temp = head;

       while (temp != null && temp.next != null) {
           if (head2 == null) {
               head2 = temp.next;
               tail2 = head2;
           } else {
               tail2.next = temp.next;
               tail2 = tail2.next;
           }
           temp.next = temp.next.next;
           temp = temp.next;
       }

       if (head2 == null)
           return head;

       tail2.next = null;
       head2 = reverse(head2);

       Node head3 = null, tail3 = null;
       while (head != null && head2 != null) {
           if (head.data < head2.data) {
               if (head3 == null) {
                   head3 = head;
                   tail3 = head3;
               } else {
                   tail3.next = head;
                   tail3 = tail3.next;
               }
               head = head.next;
           } else {
               if (head3 == null) {
                   head3 = head2;
                   tail3 = head3;
               } else {
                   tail3.next = head2;
                   tail3 = tail3.next;
               }
               head2 = head2.next;
           }
       }

       while (head != null) {
           tail3.next = head;
           tail3 = tail3.next;
           head = head.next;
       }

       while (head2 != null) {
           tail3.next = head2;
           tail3 = tail3.next;
           head2 = head2.next;
       }

       tail3.next = null;

       return head3;
   }

   public Node reverse(Node head) {
       Node prev = null, curr = head;
       while (curr != null) {
           Node next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       
       return prev;
   }
}