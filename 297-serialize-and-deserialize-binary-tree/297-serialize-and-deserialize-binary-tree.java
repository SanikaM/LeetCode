/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        return ser(root, "");
    }
    
    private String ser(TreeNode root, String str) {
        
        if(root == null)
            str += "null,";
        else {
        
            str += String.valueOf(root.val) + ",";
            str = ser(root.left, str);
            str = ser(root.right, str);
            
        }
        
        return str;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] strArr = data.split(",");
        
        List list = new ArrayList(Arrays.asList(strArr));
            
        return deser(list);
    }
    
    private TreeNode deser(List<String> list) {
        
        if(list.get(0).equals("null")) {
         list.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(list.get(0));
        root.left = deser(list);
        root.right = deser(list);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));