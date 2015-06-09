package easy;

public class MinimumDepthofBinaryTree {
	//到达叶节点的最短路径
	public static int minDepth(TreeNode root){
		// 到叶节点
		// null root
		if(root==null){
			System.out.println("here 1 ");
			return 0;
		}
		System.out.println("Root right now : "+ root.val);

		//if(root.left ==null && root.right==null){
		//	System.out.println("here 2 ");
		//	return 1;
		//}
		// one child
		if(root.left==null) return 1+minDepth(root.right);
		else if(root.right==null) return 1+minDepth(root.left);
		// two children
		System.out.println("here base ");
		return 1+Math.min(minDepth(root.left), minDepth(root.right));
	}
	public static void main(String arg[]){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		
		a.left = b;
		a.right = c;
		b.left = d;
		
		System.out.println(minDepth(a));
	}
}
