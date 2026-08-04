class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }

        int fromStart = len - n;
        ListNode dummy = new ListNode(-1);
        temp = dummy;
        temp.next = head;
        while(temp.next != null && fromStart > 0) {
            temp = temp.next;
            fromStart--;
        }

        temp.next = temp.next.next;
        return dummy.next;
    }
}
