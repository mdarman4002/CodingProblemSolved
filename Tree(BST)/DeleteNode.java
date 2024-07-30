public class DeleteNode {
    
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
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{// case 1:- if root.left and root.right both are null
            // leaf node
            if(root.left == null && root.right==null && root.data == val){
                return null;
            }
            // case 2:- if either root.left or  root.right is null then return opposite one
            // sinle child
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
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
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
    } 
} 
