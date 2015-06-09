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
	public static boolean isSymmetric(TreeNode root){
	        if (root == null) return true;
	        return isSymmetric(root.left, root.right);
	    }
	// Returns whether tree 'left' is mirror of tree 'right'
	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		// Case 1: both are null - return true
		if (left == null && right == null) return true;
		// Case 2: one is null but not the other - return false
		if (left == null || right == null) return false;
		// Case 3: both are not null - check whether they're equal and left/right subtrees are mirrors
		return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
