/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    void reverse(ListNode head, ListNode tail) {
        // We just need to reverse the connections
        ListNode cur = head, prev = null;
        while(cur != tail) {
            ListNode orgNextNode = cur.next;
            cur.next = prev; // Connection reversed
            
            // Move ahead
            prev = cur;
            cur = orgNextNode;
        }

        // Correct the connection for tail as well
        cur.next = prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null)
            return head;

        // Find [beg, end] such that beg points to
        // 1st node and end points to kth node
        ListNode beg = head, end = head;

        // Go ahead k-1 times to go to the kth node (1-based)
        for(int i = 0; i < k - 1; ++i) {
            end = end.next;

            // If less than k nodes available, do nothing
            if(end == null)
                return head;
        }

        // Get the head of further k-groups in reversed order
        ListNode nextHead = reverseKGroup(end.next, k);

        // Now, reverse the current k-group, and make relevant connection
        reverse(beg, end);
        beg.next = nextHead;
        
        return end;
    }
}