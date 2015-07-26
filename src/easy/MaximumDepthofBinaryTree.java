package easy;

import java.util.LinkedList;

public class MaximumDepthofBinaryTree {
	public static int maxdepth(TreeNode root){
		if(root==null) return 0;
		return 1+ Math.max(maxdepth(root.left), maxdepth(root.right));
	}
	 //iterative BFS
	// time o(n) space o(logn)
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return 0;
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count>0){
                TreeNode tmp = queue.poll();
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
                count--;
            }
            level++;
        }
        return level;
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
