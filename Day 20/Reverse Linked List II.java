class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode leftPre = dummy;
        ListNode cur = head;

        for (int i = 0; i < left - 1; ++i) {
            leftPre = leftPre.next;
            cur = cur.next;
        }

        //reversal point
        ListNode subListHead = cur;
        ListNode preNode = null;

        for (int i = 0; i <= right - left; ++i) {
            ListNode nextNode = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = nextNode;
        }

        // Join the pieces
        leftPre.next = preNode;
        subListHead.next = cur;

        return dummy.next;
    }
}