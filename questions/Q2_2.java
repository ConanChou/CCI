/**
 * implement an algorithm to fine the kth to last element of a singly linked list.
 */

public class Q2_2 {

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
        LinkedListNode l = new LinkedListNode(12, null, null);

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
        k.addNext(l);

        return a;
    }

    static void printNode(LinkedListNode n) {
        if (n != null) {
            System.out.println(n.getValue());
        } else {
            System.out.println("LinkedList too short.");
        }
    }

    public static void main (String [] args) {
        LinkedListNode head = init();
        LinkedListNode k;
        for (int i = 0; i < 15; i++) {
            k = getKth(head, i);
            printNode(k);
        }
    }

    static LinkedListNode getKth(LinkedListNode n, int k) {
        int i = 0;
        LinkedListNode m = n;
        while (i<=k && m!=null) {
            m = m.next;
            i += 1;
        }
        if (i != k+1) return null;
        while (m != null) {
            n=n.next;
            m=m.next;
        }
        return n;
    }
}
