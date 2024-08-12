import java.util.PriorityQueue;

class FlattenLinkedList {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.data - b .data );
        
        Node itr = root;
        while(root.next != null) {
            pq.add(itr);
        }
        Node res = new Node(0);
        Node itr2 = res;
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            itr2.next = tmp;
            if(tmp.bottom != null) pq.add(tmp.bottom);
        }
        return res.next;
    }
}