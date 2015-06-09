package easy;

public class MaximumDepthofBinaryTree {
	public static int maxdepth(TreeNode root){
		if(root==null) return 0;
		return 1+ Math.max(maxdepth(root.left), maxdepth(root.right));
	}
	public static void main(String arg[]){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		
		a.left = b;
		a.right = c;
		b.left = d;
		System.out.println(maxdepth(a));
	}
}
