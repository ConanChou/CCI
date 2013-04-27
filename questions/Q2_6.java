/**
 * Given a circular linked list, implement an algorithm which returns node at 
 * the beginning of the loop. 
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node’s next pointer
 * points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * output: C
 */

public class Q2_6 {

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
        k.addNext(d);

        return a;
    }

    static void printLinkedList(LinkedListNode n) {
        while(n != null) {
            System.out.println(n.getValue());
            n = n.next;
        }
    }

    static void printNode(LinkedListNode n) {
        if (n != null) {
            System.out.println(n.getValue());
        } else {
            System.out.println("LinkedList node is null.");
        }
    }

    public static void main (String [] args) {
        LinkedListNode head = init();
        LinkedListNode circularHead = findCircularHead(head);
        printNode(circularHead);
    }

    static LinkedListNode findCircularHead(LinkedListNode n) {
        LinkedListNode fast = null;
        LinkedListNode slow = null;

        if (n == null) return null;
        if (n.next != null && n.next.next != null) {
            fast = n.next.next;
            slow = n.next;
        }

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = n;
        while (slow != fast && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow == n.next) {
            return null;
        }

        return slow;
    }
}
