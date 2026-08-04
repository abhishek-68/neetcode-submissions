class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        int n = 0;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
            n++;
        }

        temp = head;

        for (int i = 0; i < n / 2; i++) {
            ListNode last = stack.pop();

            ListNode next = temp.next;
            temp.next = last;
            last.next = next;

            temp = next;
        }

        temp.next = null;
    }
}