public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode curr = head, prev = null;
        while(curr != null) {
            prev = curr;
            curr.next =  curr;
            len++;
        }

        k = k % len;
        if(k == 0) return head;
        prev.next = head;
        curr = head;
        for(int i = 0; i < (len -k); i++) {
            prev = curr;
            curr =curr.next;
        }
        prev.next = null;
        return curr;

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new RotateRight().rotateRight(head, 2));
    }
}