/**
 * implement a function to check if a linked list is a palindrome.
 */
import java.util.Stack;

public class Q2_7 {

    static LinkedListNode init() {

        LinkedListNode a = new LinkedListNode(1, null, null);
        LinkedListNode b = new LinkedListNode(2, null, null);
        LinkedListNode c = new LinkedListNode(3, null, null);
        LinkedListNode d = new LinkedListNode(2, null, null);
        LinkedListNode e = new LinkedListNode(1, null, null);
        LinkedListNode f = new LinkedListNode(1, null, null);

        a.addNext(b);
        b.addNext(c);
        c.addNext(d);
        d.addNext(e);
        //e.addNext(f);

        return a;
    }

    static void printLinkedList(LinkedListNode n) {
        while(n != null) {
            System.out.println(n.getValue());
            n = n.next;
        }
    }
    public static void main(String[] srgs) {
        LinkedListNode head = init();
        System.out.println(isPalindrome(head)?"is palindrome":"is not palindrome");
    }

    static boolean isPalindrome(LinkedListNode n) {
        if (n == null) return true;

        LinkedListNode fast = n;
        LinkedListNode slow = n;

        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.getValue());
            fast = fast.next.next;
            slow = slow.next;
        }

        //odd
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.getValue()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
