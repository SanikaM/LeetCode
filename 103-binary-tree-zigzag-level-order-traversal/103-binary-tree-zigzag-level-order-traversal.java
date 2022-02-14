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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        // Time complexity - O(n)
        if(root == null)
            return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        Boolean reverse = false;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Integer> levels = new ArrayList();
            while(size-- > 0){
                root = queue.poll();
                levels.add(root.val);
                
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
        
            }
            if(reverse)
                Collections.reverse(levels);
            result.add(levels);
            reverse = !reverse;
        }
        return result;
    }
}