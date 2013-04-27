/**
 * write code to partition a linked list around a value x, such that all nodes 
 * less than x come before all nodes grater than or equal to x.
 */

public class Q2_4 {

    static LinkedListNode init() {

        LinkedListNode a = new LinkedListNode(4, null, null);
        LinkedListNode b = new LinkedListNode(7, null, null);
        LinkedListNode c = new LinkedListNode(2, null, null);
        LinkedListNode d = new LinkedListNode(4, null, null);
        LinkedListNode e = new LinkedListNode(1, null, null);
        LinkedListNode f = new LinkedListNode(3, null, null);
        LinkedListNode g = new LinkedListNode(5, null, null);
        LinkedListNode h = new LinkedListNode(8, null, null);
        LinkedListNode i = new LinkedListNode(6, null, null);
        LinkedListNode j = new LinkedListNode(12, null, null);
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
        LinkedListNode newHead = partition(head, 5);
        printLinkedList(newHead);
        
        partition(null, 2);
    }

    static LinkedListNode partition(LinkedListNode n, int p) {
        LinkedListNode beforeHead = null;
        LinkedListNode beforeTail = null;
        LinkedListNode afterHead = null;
        LinkedListNode afterTail = null;

        while (n != null) {
            if (n.getValue() < p) {
                if (beforeHead == null) {
                    beforeHead = n;
                    beforeTail = n;
                } else {
                    beforeTail.next = n;
                    beforeTail = beforeTail.next;
                }
            } else {
                if (afterHead == null) {
                    afterHead = n;
                    afterTail = n;
                } else {
                    afterTail.next = n;
                    afterTail = afterTail.next;
                }
            }
            n = n.next;
        }

        if (beforeTail != null) {
            beforeTail.next = afterHead;
            return beforeHead;
        }

        return afterHead;
    }
}
