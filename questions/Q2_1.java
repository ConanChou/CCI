/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
import java.util.Set;
import java.util.HashSet;

public class Q2_1 {
    static LinkedListNode init() {

        LinkedListNode a = new LinkedListNode(1, null, null);
        LinkedListNode b = new LinkedListNode(2, a, null);
        LinkedListNode c = new LinkedListNode(3, b, null);
        LinkedListNode d = new LinkedListNode(4, c, null);
        LinkedListNode e = new LinkedListNode(3, d, null);
        LinkedListNode f = new LinkedListNode(5, e, null);
        LinkedListNode g = new LinkedListNode(4, f, null);

        a.addNext(b);
        b.addNext(c);
        c.addNext(d);
        d.addNext(e);
        e.addNext(f);
        f.addNext(g);

        return a;
    }

    static void printLinkedList(LinkedListNode n) {
        while(n != null) {
            System.out.println(n.getValue());
            n = n.next;
        }
    }

    public static void main (String [] args) {
        System.out.println("with extra data structure");
        LinkedListNode head = init();
        removeDup(head);
        printLinkedList(head);

        System.out.println("without extra data structure");
        LinkedListNode head2 = init();
        removeDupFU(head2);
        printLinkedList(head2);

        //test extreme
        removeDup(null);
        removeDupFU(null);

    }

    static void removeDup(LinkedListNode n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != null) {
            int current = n.getValue();
            if (set.contains(current)) {
                n.pre.next = n.next;
            } else {
                set.add(current);
            }
            n = n.next;
        }
    }

    static void removeDupFU(LinkedListNode n) {
        LinkedListNode m;
        while (n != null) {
            m = n.next;
            while (m != null) {
                if(n.getValue() == m.getValue()) {
                    m.pre.next = m.next;
                }
                m = m.next;
            }
            n = n.next;
        }

    }
}

