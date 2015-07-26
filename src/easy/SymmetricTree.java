package easy;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
	// recursive DFS
	public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    public boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left!=null && right!=null && left.val==right.val){
            return helper(left.left, right.right) && helper(left.right,right.left);
        }
        return false;
    }
    //iterative bfs
}
