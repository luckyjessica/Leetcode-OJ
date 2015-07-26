package medium;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * @author JieXu
 *
 */
public class KthSmallestElementinaBST {
	//method 1 :用二分法查找
	public static int kthsmallestinBST(TreeNode root,int k){
		int count = countnodes(root.left);
		// if kth node is the root
		if(1+count == k) return root.val;
		// kth is in the left subtree
		// kth in the left subtree = kth in the original tree
		else if(1+count > k) return kthsmallestinBST(root.left,k);
		else return kthsmallestinBST(root.right, k - count -1);
	}
	
	// method 2: in-order recursive
	// better keep these two variables in a wrapper class
	    private static int number = 0;
	    private static int count = 0;

	    public int inorderrecursive(TreeNode root, int k) {
	        count = k;
	        helper(root);
	        return number;
	    }

	    public void helper(TreeNode n) {
	        if (n.left != null) helper(n.left);
	        count--;
	        if (count == 0) {
	            number = n.val;
	            return;
	        }
	        if (n.right != null) helper(n.right);
	    }
	 // method 3 : in-order iterative
	  public int inorderiterative(TreeNode root, int k) {
		  Stack<TreeNode> st = new Stack<>();
		  while (root != null) {
			  st.push(root);
			  root = root.left;
	        }

	        while (k != 0) {
	            TreeNode n = st.pop();
	            k--;
	            if (k == 0) return n.val;
	            TreeNode right = n.right;
	            while (right != null) {
	                st.push(right);
	                right = right.left;
	            }
	        }

	        return -1; // never hit if k is valid
	  }
	public static int countnodes(TreeNode root){
		if(root==null) return 0;
		return 1 + countnodes(root.left) + countnodes(root.right);
	}
}
