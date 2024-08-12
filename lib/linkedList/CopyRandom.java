class Node {
    public int val;
    public Node next;
    public Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandom {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }

        // copy random pointer
        curr = head;
        while(curr != null) {
            Node random = curr.random;
            curr.next.random = random.next;
            curr = curr.next.next;
        }

        // separate out nodes
        Node newHead = curr.next;
        Node itr = newHead;
        while(itr != null) {
            itr.next = itr.next.next;
            itr = itr.next;
        }

        return newHead;
    }
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(new CopyRandom().copyRandomList(head));
    }
}
