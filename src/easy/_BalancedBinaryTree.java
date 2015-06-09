package easy;

public class _BalancedBinaryTree {
	// in which the depth of the two subtrees of every node never differ by more than 1.
	// 有可能root两边子树深度一样，但是root.left下的子子树深度差很多
	public static boolean isBalanced(TreeNode root){
		if(root==null) return true;
		if(Math.abs(depth(root.left)-depth(root.right))>1) return false;
		else return isBalanced(root.left) && isBalanced(root.right);
	}
	public static int depth(TreeNode root){
		if(root==null) return 0;
		return 1+ Math.max(depth(root.left), depth(root.right));
	}
	public static void main(String arg[]){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		
		a.left = b;
		a.right = c;
		b.left = d;
		
		System.out.println(isBalanced(a));
}
}
