class Solution {
    ListNode reverseLL(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode last = reverseLL(node.next);
        node.next.next = node;
        node.next = null;

        return last;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHalf = reverseLL(slow);
        ListNode cur = head;

        while (revHalf.next != null) {
            ListNode tempFront = cur.next;
            cur.next = revHalf;

            ListNode tempBack = revHalf.next;
            revHalf.next = tempFront;

            revHalf = tempBack;
            cur = tempFront;
        }
    }
}