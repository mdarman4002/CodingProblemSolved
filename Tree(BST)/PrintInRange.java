public class PrintInRange {
    
    public static void main(String[] args) {
        int[] nodes = {0,1,2,3,4,5,6,7,8,9,10};
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
           root =  Node.insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();
        printRange(root, 4,7);
       
    }public static void printRange(Node root , int start, int end){
        if(root == null){
            return;
        }
        if(root.data >= start &&  end >= root.data){
            printRange(root.left, start, end);
            System.out.print(root.data + " ");
            printRange(root.right, start, end);
        }else if(root.data > start){
            printRange(root.left, start, end);
        }else{
            printRange(root.right, start, end);
        }
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
    } 
} 

