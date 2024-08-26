public class DeleteNode {
    
    /**
     * Main method to test the delete node functionality
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int[] nodes = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
           root =  Node.insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();

        root = delete(root, 4);
        System.out.println();
        inorder(root);
       
    }
    
    /**
     * Deletes a node with the given value from the binary search tree
     * @param root the root of the binary search tree
     * @param val the value to be deleted
     * @return the updated root of the binary search tree
     */
    public static Node delete(Node root, int val){
        if(root == null){
            return null; // tree is empty, nothing to delete
        }
        
        if(root.data < val){
            // value to be deleted is in the right subtree
            root.right = delete(root.right, val);
        }else if(root.data > val){
            // value to be deleted is in the left subtree
            root.left = delete(root.left, val);
        }else{// case 1:- if root.left and root.right both are null
            // leaf node
            if(root.left == null && root.right==null && root.data == val){
                return null;
            }
            // case 2:- if either root.left or  root.right is null then return opposite one
            // single child
            else if(root.left == null && root.data == val){
                return root.right;
            }else if(root.right == null && root.data == val){
                return root.left;
            }
            // case 3 
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right, inorderSuccessor.data); 
        }
        return root;
    }
    
    /**
     * Performs an in-order traversal of the binary search tree and prints the node values
     * @param root the root of the binary search tree
     */
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    /**
     * Finds the in-order successor of a node in the binary search tree
     * @param root the root of the binary search tree
     * @return the in-order successor node
     */
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    
    /**
     * Node class representing a node in the binary search tree
     */
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        /**
         * Inserts a new node with the given value into the binary search tree
         * @param root the root of the binary search tree
         * @param n the value to be inserted
         * @return the updated root of the binary search tree
         */
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
    } 
}
