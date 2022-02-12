/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode,TreeNode> nodeParent){
        
        if(node == null)
            return;
        
        if(parent != null)
            nodeParent.put(node, parent);
        
        dfs(node.left, node, nodeParent);
        dfs(node.right, node, nodeParent);
    }
    
    private void addNodesToQueue(TreeNode node, Queue<TreeNode> queue, Set<TreeNode> visited ) 
    {
        
        if(node == null)
            return;
        if(visited.contains(node))
            return;
        visited.add(node);
        queue.add(node);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> nodeParent = new HashMap<>();
        dfs(root, null, nodeParent);
        
        List<Integer> resultNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        queue.add(target);
        int distance = 0;
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            for(int i=0; i<size;i++){
                
                TreeNode node = queue.poll();
                if(distance == k)
                    resultNodes.add(node.val);
                
                addNodesToQueue(node.left, queue, visited);
                addNodesToQueue(node.right, queue, visited);
                addNodesToQueue(nodeParent.getOrDefault(node, null), queue, visited);
            }
            ++distance;
            if(distance > k)
                break;
        }
        
        return resultNodes;
    }
}