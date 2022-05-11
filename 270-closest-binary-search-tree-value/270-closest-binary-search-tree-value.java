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
   
    
    
    public int closestValue(TreeNode root, double target) {
     
        int min = root.val;    
        double diff = Math.abs(target - (double) root.val);
        
        if(target > root.val && root.right != null)
                min = closestValue(root.right, target);
           
            if(target < root.val && root.left != null)
                min = closestValue(root.left, target);
           
            double nextDiff = Math.abs(target - (double) min);
          
            if(nextDiff < diff)
                return min;
       
        return root.val;
    }
    
    
}