class BSTNode {

    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int data) {
        this.data = data;
    }
}

public class BST {

    private BSTNode insert(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    private boolean search(BSTNode root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data > root.data) {
            return search(root.right, data);
        } else {
            return search(root.left, data);
        }
    }

    private int findMinIterative(BSTNode root) {
        BSTNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    private int findMaxIterative(BSTNode root) {
        BSTNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    private int findMinRecursive(BSTNode root) {
        if (root == null) {
            return -1;
        } else if (root.left == null) {
            return root.data;
        } else {
            return findMinRecursive(root.left);
        }
    }

    private int findMaxRecursive(BSTNode root) {
        if (root == null) {
            return -1;
        } else if (root.right == null) {
            return root.data;
        } else {
            return findMaxRecursive(root.right);
        }
    }

    private int findHeight(BSTNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void preorder(BSTNode root) {
        if(root == null){
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    private void postorder(BSTNode root) {
        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    private void inorder(BSTNode root) {
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        BSTNode root = bst.insert(null, 3);
        root = bst.insert(root, 5);
        root = bst.insert(root, 6);
        root = bst.insert(root, 1);
        root = bst.insert(root, 9);
        root = bst.insert(root, 2);

        System.out.println("RESULT--- " + bst.search(root, 3));
        System.out.println("MIN ITER--- " + bst.findMinIterative(root));
        System.out.println("MAX ITER--- " + bst.findMaxIterative(root));
        System.out.println("MIN REC --- " + bst.findMinRecursive(root));
        System.out.println("MAX REC --- " + bst.findMaxRecursive(root));
        System.out.println("TREE HEIGHT --- " + bst.findHeight(root));
        System.out.println("PREORDER --- "); bst.preorder(root);
        System.out.println("POSTORDER --- "); bst.postorder(root);
        System.out.println("INORDER --- "); bst.inorder(root);
    }
}
