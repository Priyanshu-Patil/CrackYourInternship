class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    // Function to rearrange the linked list in zigzag order
    Node rearrangeLinkedListZigzag(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node node = head;
        boolean flag = true; // true indicates < relation expected, false indicates > relation expected

        while (node != null && node.next != null) {
            if (flag) {
                if (node.data > node.next.data) {
                    // Swap data
                    int temp = node.data;
                    node.data = node.next.data;
                    node.next.data = temp;
                }
            } else {
                if (node.data < node.next.data) {
                    // Swap data
                    int temp = node.data;
                    node.data = node.next.data;
                    node.next.data = temp;
                }
            }
            flag = !flag; // flip flag for next pair
            node = node.next;
        }

        return head;
    }

    // Function to insert a new node at the end of the list
    Node insert(int data, Node head) {
        if (head == null) {
            return new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
            return head;
        }
    }

    // Function to print the linked list
    void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head = null;

        head = list.insert(2, head);
        head = list.insert(3, head);
        head = list.insert(5, head);
        head = list.insert(9, head);
        head = list.insert(11, head);
        head = list.insert(12, head);

        Node zigZagList = list.rearrangeLinkedListZigzag(head);
        list.printList(zigZagList);
    }
}