public class Solution {
    public int rob(TreeNode root) {
        if( root == null ) return 0;
        int val = 0;
        if( root.left != null ){
            val += rob(root.left.left) + rob(root.left.right);
        }
        if( root.right != null ){
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max( val + root.val, rob(root.left) + rob(root.right));
    }
}


public class Solution {
    public int rob(TreeNode root) {
        return helper(root, new HashMap<TreeNode,Integer>());
    }
    public int helper(TreeNode root , Map<TreeNode,Integer> map ){
        if( root == null ) return 0;
        if( map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if( root.left != null ){
            val += helper(root.left.left,map) + helper(root.left.right,map);
        }
        if( root.right != null ){
            val += helper(root.right.left,map) + helper(root.right.right,map);
        }
        
        val = Math.max( val + root.val, helper(root.left,map) + helper(root.right,map));
        map.put(root,val);
        
        return val;
    }
}