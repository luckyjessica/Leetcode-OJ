package easy;
/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w 
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * @author JieXu
 *
 */
//BST!!!!!
//left child smaller than root, right child bigger than root
public class LowestCommonAncestorofaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(q==p) return p;
		while(root != null){
			if((p.val-root.val) * (q.val-root.val) <=0 ) return root;
			else if(p.val>root.val) root = root.right;
			else root = root.left;
		}
		return null;
	}
}
