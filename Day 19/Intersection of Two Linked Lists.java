public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;

            if (curA == null && curB == null) return null;
            if (curA == null) curA = headB;
            if (curB == null) curB = headA;
        }

        return curA;
    }
}