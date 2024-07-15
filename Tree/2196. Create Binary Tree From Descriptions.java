/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();

        for(int desc[] : descriptions){
            if(!map.containsKey(desc[0])){
                map.put(desc[0],new TreeNode(desc[0]));
            }
            if(!map.containsKey(desc[1])){
                map.put(desc[1], new TreeNode(desc[1]));
            }
            if(desc[2] == 1){
                map.get(desc[0]).left = map.get(desc[1]);
            }else{
                map.get(desc[0]).right = map.get(desc[1]);
            }
            set.add(desc[1]);
        }
        for(int desc[] : descriptions){
            if(!set.contains(desc[0])){
                return map.get(desc[0]);
            }
        }return null;

    }
}
