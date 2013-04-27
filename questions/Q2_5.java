/**
 * You have two numbers represented by a linked list, where each node contains 
 * a sin-gle digit. The digits are stored in reverse order, such that the 1’s 
 * digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 * FOLLOW UP
 * suppose the digits are stored in forward order. repeat the above problem.
 * EXAMPLE
 * input: (6 -> 1 -> 7) + (2 -> 9 -> 5). taht is, 617 + 295
 * output: 9 -> 1 -> 2. that is, 912.
 */

public class Q2_5 {

    public static void main (String [] args) {
        LinkedListNode a1 = new LinkedListNode(4, null, null);
        LinkedListNode a2 = new LinkedListNode(1, null, null);
        LinkedListNode a3 = new LinkedListNode(5, null, null);

        a1.addNext(a2);
        a2.addNext(a3);

        LinkedListNode b1 = new LinkedListNode(5, null, null);
        LinkedListNode b2 = new LinkedListNode(9, null, null);
        LinkedListNode b3 = new LinkedListNode(5, null, null);
        LinkedListNode b4 = new LinkedListNode(6, null, null);

        b1.addNext(b2);
        b2.addNext(b3);
        b3.addNext(b4);

        LinkedListNode sumA = addReverse(a1, b1);
        printLinkedList(sumA);

        LinkedListNode sumB = addForward(a1, b1);
        printLinkedList(sumB);
    }

    static void printLinkedList(LinkedListNode n) {
        while(n != null) {
            System.out.println(n.getValue());
            n = n.next;
        }
    }

    static LinkedListNode addReverse(LinkedListNode a, LinkedListNode b) {
        LinkedListNode resultHead = null;
        LinkedListNode resultTail = null;
        boolean hasCarrier = false;
        int tmp, tmpa, tmpb;
        while (a != null || b != null) {
            if (a != null) {
                tmpa = a.getValue();
                a = a.next;
            } else {
                tmpa = 0;
            }
            if (b != null) {
                tmpb = b.getValue();
                b = b.next;
            } else {
                tmpb = 0;
            }
            tmp = tmpa + tmpb;
            if (hasCarrier) tmp += 1;
            if (tmp >= 10) {
                hasCarrier = true;
                tmp = tmp%10;
            } else {
                hasCarrier = false;
            }

            if (resultHead == null) {
                resultHead = new LinkedListNode(tmp, null, null);
                resultTail = resultHead;
            } else {
                resultTail.next = new LinkedListNode(tmp, null, null);
                resultTail = resultTail.next;
            }
        }

        if (hasCarrier) {
            resultTail.next = new LinkedListNode(1, null, null);
        }
        return resultHead;
    }

    static LinkedListNode addForward(LinkedListNode a, LinkedListNode b) {
        LinkedListNode aHead = a;
        LinkedListNode bHead = b;
        LinkedListNode rHead = null;
        LinkedListNode rTail = null;
        LinkedListNode zAH = null;
        LinkedListNode zAT = null;
        LinkedListNode zBH = null;
        LinkedListNode zBT = null;

        LinkedListNode carrierHead = new LinkedListNode(0, null, null);
        LinkedListNode carrierTail = carrierHead;
        boolean returnR = true;
        int tmp;

        while (a != null || b != null) {
            if (a == null) {
                if (zAH == null) {
                    zAH = new LinkedListNode(0, null, null);
                    zAT = zAH;
                } else {
                    zAT.next = new LinkedListNode(0, null, null);
                    zAT = zAT.next;
                }
            } else {
                returnR = returnR && (a.getValue() == 0);
                a = a.next;
            }
            if (b == null) {
                if (zBH== null) {
                    zBH = new LinkedListNode(0, null, null);
                    zBT = zBH;
                } else {
                    zBT.next = new LinkedListNode(0, null, null);
                    zBT = zBT.next;
                }
            } else {
                b = b.next;
            }
        }

        if (returnR) return bHead;

        if (zAH != null) {
            zAT.next = aHead;
            a = zAH;
        } else {
            a = aHead;
        }

        if (zBH != null) {
            zBT.next = bHead;
            b = zBH;
        } else {
            b = bHead;
        }

        while (a != null || b != null) {
            tmp = a.getValue() + b.getValue();
            if (tmp >= 10) {
                carrierTail.setValue(1);
                tmp = tmp%10;
            }
            carrierTail.next = new LinkedListNode(0, null, null);
            carrierTail = carrierTail.next;
            if (rHead == null) {
                rHead = new LinkedListNode(tmp, null, null);
                rTail = rHead;
            } else {
                rTail.next = new LinkedListNode(tmp, null, null);
                rTail = rTail.next;
            }
            a = a.next;
            b = b.next;
        }

        if (carrierHead.getValue() == 0) carrierHead = carrierHead.next;

        return addForward(carrierHead, rHead);
    }
}
