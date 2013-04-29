import java.lang.Comparable;

public class BinaryTreeNode implements Comparable<BinaryTreeNode> {

    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;
    int key;

    public BinaryTreeNode(int key, BinaryTreeNode parent, BinaryTreeNode left, BinaryTreeNode right) {
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int compareTo(BinaryTreeNode n) {
        int diff = this.key - n.key;
        if (diff > 0) return 1;
        if (diff == 0) return 0;
        return -1;
    }
}
