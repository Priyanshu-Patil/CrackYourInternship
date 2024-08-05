class Solution {
    public boolean isPalindrome(ListNode head) {

        //Finding the middle node
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse list from middle node
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        //check if palindrome
        while (prev != null) {
            if (head.val != prev.val) return false;

            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}