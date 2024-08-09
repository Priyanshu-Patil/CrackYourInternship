class Solution {
    // Function to reverse the linked list
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Function to get the length of the linked list
    public int length(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // Function to subtract two linked lists
    public Node subLinkedList(Node head1, Node head2) {
        // Removing leading zeros
        while (head1 != null && head1.data == 0) {
            head1 = head1.next;
        }
        while (head2 != null && head2.data == 0) {
            head2 = head2.next;
        }

        if (head1 == null && head2 == null) {
            return new Node(0);
        }

        int n1 = length(head1);
        int n2 = length(head2);

        if (n2 > n1) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        if (n1 == n2) {
            Node temp1 = head1;
            Node temp2 = head2;
            while (temp1 != null && temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            if (temp1 != null && temp2 != null && temp2.data > temp1.data) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }

        head1 = reverseList(head1);
        head2 = reverseList(head2);

        Node newList = null;
        Node last = null;
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null) {
            int small = temp2 != null ? temp2.data : 0;
            if (temp1.data < small) {
                temp1.next.data = temp1.next.data - 1;
                temp1.data += 10;
            }

            Node newNode = new Node(temp1.data - small);
            if (newList == null) {
                newList = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }

            temp1 = temp1.next;
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }

        newList = reverseList(newList);

        while (newList != null && newList.data == 0) {
            newList = newList.next;
        }

        return newList != null ? newList : new Node(0);
    }

}