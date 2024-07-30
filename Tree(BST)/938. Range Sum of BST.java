class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            // sum += root.val;
            sum += rangeSumBST(root.left, low, high);
            sum += root.val;
            sum += rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            sum += rangeSumBST(root.right, low, high);
        } else {
            sum += rangeSumBST(root.left, low, high);
        }
        return sum;
    }
}
