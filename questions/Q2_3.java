/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
 * only access to that node.
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */

public class Q2_3 {

    static LinkedListNode init() {

        LinkedListNode a = new LinkedListNode(1, null, null);
        LinkedListNode b = new LinkedListNode(2, null, null);
        LinkedListNode c = new LinkedListNode(3, null, null);
        LinkedListNode d = new LinkedListNode(4, null, null);
        LinkedListNode e = new LinkedListNode(5, null, null);
        LinkedListNode f = new LinkedListNode(6, null, null);
        LinkedListNode g = new LinkedListNode(7, null, null);
        LinkedListNode h = new LinkedListNode(8, null, null);
        LinkedListNode i = new LinkedListNode(9, null, null);
        LinkedListNode j = new LinkedListNode(10, null, null);
        LinkedListNode k = new LinkedListNode(11, null, null);

        a.addNext(b);
        b.addNext(c);
        c.addNext(d);
        d.addNext(e);
        e.addNext(f);
        f.addNext(g);
        g.addNext(h);
        h.addNext(i);
        i.addNext(j);
        j.addNext(k);

        return a;
    }

    static void printLinkedList(LinkedListNode n) {
        while(n != null) {
            System.out.println(n.getValue());
            n = n.next;
        }
    }

    public static void main (String [] args) {
        LinkedListNode head = init();
        LinkedListNode newHead = removeMid(head);
        printLinkedList(newHead);
    }

    static LinkedListNode removeMid(LinkedListNode n) {
        LinkedListNode fast, slow;
        fast = n;
        slow = n;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.v = slow.next.v;
        slow.next = slow.next.next;

        return n;
    }
}
