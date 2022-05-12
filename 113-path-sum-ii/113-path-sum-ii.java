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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(root, targetSum, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        
        if(root == null)
            return;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null && root.val == sum) 
            result.add(path);
        
        dfs(root.left, sum-root.val, new ArrayList(path), result);
        dfs(root.right, sum-root.val, new ArrayList(path), result);
        
    }
}