
public class BinarySearchTree {
    BinaryTreeNode root = null;

    public BinarySearchTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void insert(BinaryTreeNode n) {
        BinaryTreeNode runner = this.root;
        BinaryTreeNode parentPostion = null;
        while (runner != null) {
            parentPostion = runner;
            if (n.compareTo(runner) <= 0) {
                runner = runner.left;
            } else {
                runner = runner.right;
            }
        }
        n.parent = parentPostion;
        if (parentPostion == null) {
            this.root = n;
        } else if (n.compareTo(parentPostion) <= 0) {
            parentPostion.left = n;
        } else {
            parentPostion.right = n;
        }
    }

    public void delete(BinaryTreeNode n) {
        BinaryTreeNode toBeDeletedNode, toBeLinkedNode;
        if (n.left == null || n.right == null) {
            toBeDeletedNode = n;
        } else {
            toBeDeletedNode = treeSuccessor(n);
        }
        if (toBeDeletedNode.left != null) {
            toBeLinkedNode = toBeDeletedNode.left;
        } else {
            toBeLinkedNode = toBeDeletedNode.right;
        }
        if (toBeLinkedNode != null) {
            toBeLinkedNode.parent = toBeDeletedNode.parent;
        }
        if (toBeDeletedNode.parent == null) {
            this.root = toBeLinkedNode;
        } else if (toBeDeletedNode == toBeDeletedNode.parent.left) {
            toBeDeletedNode.parent.left = toBeLinkedNode;
        } else {
            toBeDeletedNode.parent.right = toBeLinkedNode;
        }
        if (toBeDeletedNode != n) {
            n.key = toBeDeletedNode.key;
        }
    }

    public void delete(int i) {
        delete(search(i));
    }

    public void inorderTreeWalk(BinaryTreeNode root) {
        if (root != null) {
            inorderTreeWalk(root.left);
            System.out.print(root.key + " ");
            inorderTreeWalk(root.right);
        }
    }
    public void inorderTreeWalk() {
        inorderTreeWalk(this.root);
    }

    public BinaryTreeNode treeSuccessor(BinaryTreeNode n) {
        BinaryTreeNode runner = n;
        if (n.right == null) {
            while (runner.parent.right == runner) {
                runner = runner.parent;
            }
            return runner.parent;
        }
        return minmum(n.right);
    }

    public BinaryTreeNode minmum(BinaryTreeNode n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public BinaryTreeNode search(int i) {
        return search(this.root, i);
    }

    public BinaryTreeNode search(BinaryTreeNode n, int i) {
        while (n != null && i != n.key) {
            if (i <= n.key) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return n;
    }

    public static void main (String [] args)
    {
        BinarySearchTree bst = new BinarySearchTree(new BinaryTreeNode(10, null, null,null));
        for (int i = 0; i<20; i++) {
            BinaryTreeNode n = new BinaryTreeNode(i, null, null, null);
            bst.insert(n);
        }
        bst.inorderTreeWalk();
        System.out.println();
        BinaryTreeNode n = new BinaryTreeNode(17, null, null, null);
        bst.insert(n);
        bst.inorderTreeWalk();
        System.out.println();
        bst.delete(15);
        System.out.println(bst.root.key);
        bst.inorderTreeWalk();
    }
}
