public class BuildBST {
    public static void main(String[] args) {
        int[] nodes = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = Node.insert(root, nodes[i]);
        }
        inorder(root);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        public static Node insert(Node root, int n) {
            if (root == null) {
                root = new Node(n);
                return root;
            }
            if (root.data > n) {
                root.left = insert(root.left, n);
            }
            if (root.data < n) {
                root.right = insert(root.right, n);
            }
            return root;
        }
    } // <--- This brace was missing
} // <--- This brace was missing