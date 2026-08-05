/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        // step 1 : Insert the new node in between the original list
        Node curr = head;
        while(curr != null) {
            Node currNext = curr.next;
            Node newCurr = new Node(curr.val);
            newCurr.next = currNext;
            curr.next = newCurr;
            curr = currNext;
        }

        // step 2 : Deep copy of random pointers
        curr = head;
        while(curr != null) {
            if(curr.random == null) {
                curr.next.random = null;
            }
            else {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // step 3 : Deep copy of next pointers and recovering old linked list

        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;

        while(curr != null && newCurr != null) {
            curr.next = curr.next == null ? null : curr.next.next;
            newCurr.next = newCurr.next == null ? null : newCurr.next.next;

            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}















