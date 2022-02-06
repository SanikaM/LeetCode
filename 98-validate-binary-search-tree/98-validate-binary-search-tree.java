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
    public boolean isValidBST(TreeNode root) {
        /*
        time complexity - O(n)
        space complexity - O(n) - stack value equal to all tree nodes
        */
      return validate(root, null, null);
    }
    
    public boolean validate(TreeNode root, Integer max, Integer min)
    {
        if(root==null)
            return true;
        else if(max!=null && root.val>=max || min != null && root.val <= min) 
            return false;
        else
        {
            return validate(root.left, root.val, min) && validate(root.right, max, root.val);
        }
    }
}



/*
Stack Approach 

  Stack<TreeNode> stack = new Stack<>();
        double leftChild = -Double.MAX_VALUE;
        
        while(!stack.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
        
        root= stack.pop();
        if(root.val <= leftChild) return false;
            leftChild = root.val;
            root = root.right;
        
        }
        
        return true;
*/