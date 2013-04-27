
abstract class Node<T extends Number> {
    T v;

    public Node(T v) {
        this.v = v;
    }
}

class LinkedListNode extends Node<Integer> {
    LinkedListNode pre;
    LinkedListNode next;

    public LinkedListNode(int i, LinkedListNode pre, LinkedListNode next) {
        super(new Integer(i));
        this.pre = pre;
        this.next = next;
    }

    int getValue() {
        return v.intValue();
    }

    void addNext(LinkedListNode n) {
        next = n;
    }
    
    void setValue(int i) {
        this.v = new Integer(i);
    }
}
