package medium;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
1
/ \
2 3
/ \
4 5

return the root of the binary tree [4,5,2,#,#,3,1].
4
/ \
5 2
/ \
3 1
 * @author JieXu
 *
 */
class TreeNode {
	  int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
}

public class _BinaryTreeUpsideDown {
	public static TreeNode upsidedown(TreeNode root){
		if(root==null) return root;
		TreeNode parent = null;
		TreeNode parentRight = null;
		while(root!=null){
			// 需要一个临时节点
			TreeNode next = root.left;
            root.left = parentRight;
            parentRight = root.right;
            root.right = parent;
            parent = root;
            root = next;
		}
		return parent;
	}
	//递归解法，比较好理解
	public TreeNode UpsideDownBinaryTree(TreeNode root) {
	    return udtree(root, null);
	}
	 
	TreeNode udtree(TreeNode root, TreeNode parent) {
	    if(root==null) return parent; // base
	    TreeNode newRoot = udtree(root.left, root);
	    root.left = parent==null ? null : parent.right; // 1st node, both .left .right == null
	    root.right = parent;
	    return newRoot;
	}
	
	public static void inOrder(TreeNode e) {
        if (e != null) {
            inOrder(e.left);
            System.out.format("%d ", e.val);
            inOrder(e.right);
        }
    }
	public static void main(String arg[]){
		TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        inOrder(root);
        inOrder(upsidedown(root));
	}
}
