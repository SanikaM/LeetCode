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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null)
            return result;
        dfs(root, result,0);
        
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> result, int curr) {
        
        if(root == null)
            return;
        
        if(result.size() == curr) 
            result.add(root.val);
        
        dfs(root.right, result, curr+1);
        dfs(root.left, result, curr+1);
        
        
    }
}