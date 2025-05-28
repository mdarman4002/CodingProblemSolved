/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
       
        while(!queue.isEmpty()){
            
           int size = queue.size();
           for(int i = 0; i< size; i++){
               Node curNode = queue.poll();
               if(i == 0){
                   list.add(curNode.data);
               }
            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
            }
           }
            
            
        }
        return list;
    }
}
