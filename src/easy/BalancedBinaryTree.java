package easy;

public class BalancedBinaryTree {
	// in which the depth of the two subtrees of every node never differ by more than 1.
	// 有可能root两边子树深度一样，但是root.left下的子子树深度差很多
	// top-down time o(n^2)
	public static boolean isBalanced(TreeNode root){
		if(root==null) return true;
		if(Math.abs(depth(root.left)-depth(root.right))>1) return false;
		else return isBalanced(root.left) && isBalanced(root.right);
	}
	public static int depth(TreeNode root){
		if(root==null) return 0;
		return 1+ Math.max(depth(root.left), depth(root.right));
	}
	
	//bottom-up
    // time o(N)
	//这里我们用一个整数来做返回值，而0或者正数用来表示树的深度，而-1则用来比较此树已经不平衡了，
	//如果已经不平衡，则递归一直返回-1即可，也没有继续比较的必要了，
	//否则就利用返回的深度信息看看左右子树是不是违反平衡条件，如果违反返回-1，否则返回左右子树深度大的加一作为自己的深度即可。
    public boolean isBalanced2(TreeNode root) {
        return helper(root)>=0;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left==-1 || right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
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
