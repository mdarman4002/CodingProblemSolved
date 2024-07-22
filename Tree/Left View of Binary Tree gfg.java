class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> list= new ArrayList<>();
      Queue<Node> q = new LinkedList();
      if(root == null){
          return list;
      }else{
          q.add(root);
          while(!q.isEmpty()){
              int size = q.size();
              for(int i = 0; i < size; i++){
                  Node curNode = q.remove();
                  if(i == 0){
                      list.add(curNode.data);
                  }
                  if(curNode.left != null){
                      q.add(curNode.left);
                  }
                  if(curNode.right != null){
                      q.add(curNode.right);
                  }
              }
           }return list;
       }
    }
}
