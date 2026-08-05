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
        Map<Node, Node> map = new HashMap<>();

        Node oldTemp = head.next;
        Node newHead = new Node(head.val);
        Node newTemp = newHead;
        map.put(head, newTemp);

        while(oldTemp != null) {
            Node curr = new Node(oldTemp.val);
            newTemp.next = curr;
            map.put(oldTemp, curr);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        oldTemp = head;
        newTemp = newHead;

        while(oldTemp != null) {
            if(oldTemp.random != null) {
                newTemp.random = map.get(oldTemp.random);
            }

            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }

        return newHead;
    }
}
