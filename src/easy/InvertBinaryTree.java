package easy;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	// recursive
	public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
	//iterative
	public void invertBinaryTree(TreeNode root) {
        // write your code here
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
       if(root == null) return;
       queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if (tmp.left != null) queue.add(tmp.left); 
            if (tmp.right != null) queue.add(tmp.right);
            TreeNode t = tmp.left;
            tmp.left = tmp.right;
            tmp.right = t;
        }
    }
}
