package easy;

import java.util.LinkedList;

public class MinimumDepthofBinaryTree {
	//recursive
	//注意minDepth与maxDepth的区别，当仅有一边子树为空时，minDepth是另一边子树的depth。
    public int minDepthrecursive(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
	//iterative
    public static int minDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return 0;
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count>0){
                TreeNode tmp = queue.poll();
                //检测到第一个叶子Node的时候就可以返回了
                if(tmp.left==null && tmp.right==null) return ++level;
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
		TreeNode e = new TreeNode(5);
		
		a.left = b;
		a.right = c;
		b.left=d;
		c.right=e;
		
		System.out.println(minDepth(a));
	}
}
