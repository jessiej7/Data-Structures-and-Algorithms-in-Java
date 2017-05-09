public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while( !stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null ) stack.push(node.right);
            if(node.left != null ) stack.push(node.left);
        }
        return res;
        
    }
}