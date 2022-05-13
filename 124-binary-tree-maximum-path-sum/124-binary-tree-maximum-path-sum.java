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
    int max;
    public int maxPathSum(TreeNode root) {
        
        max = Integer.MIN_VALUE;
        
        helper(root);
        
        return max;
    }
    
    private int helper(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        max = Math.max(Math.max( Math.max(root.val + left + right, max), 
                      root.val + left), Math.max( root.val + right, root.val));
        
        return Math.max(Math.max(root.val, root.val + left), root.val + right);
    }
}