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
class BSTIterator {

    TreeNode curr;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        
        curr = root;
        stack = new Stack<>();
    }
    
    public int next() {
       
        while(curr != null) {
            
            stack.push(curr);
            curr = curr.left;
        }
        
        TreeNode t = stack.pop();
        curr = t.right;
        return t.val;
    }
    
    public boolean hasNext() {
        
         return curr!= null || !stack.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */