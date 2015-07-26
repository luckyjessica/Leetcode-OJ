package medium;
/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author JieXu
 *
 */
public class FlattenBinaryTreetoLinkedList {
	//Recursion: Time ~ O(N), Space ~ O(logN) 
	//Two steps:
	//1) recursively flatten leftSubTree and flatten rightSubTree;
	//2) merge leftLink and rightLink （注意这部分）:
	//connect the rightmost node of leftLink to the rightLink;
	//point root.right to root.left, and set point root.left to null.
	    public void flatten(TreeNode root) {
	        if(root==null) return;
	        flatten(root.left);
	        flatten(root.right);
	        if(root.left==null) return;
	        // merge: root-left-right
	        TreeNode tmp = root.left;
	        while (tmp.right != null){
	            tmp = tmp.right;
	        }
	        tmp.right = root.right;
	        root.right = root.left;
	        root.left = null;
	    }
	  //Iteration (no Stack): Time ~ O(N), Space ~ O(1) 
	  //类似Recursion的第二步：
	  //connect the rightmost node of leftSubTree to the rigthSubTree;
	  //point curr.right to curr.left, and point curr.left = null;
	  //move curr to curr.right (Iteration 需要这步，直至 curr == null 停止).
	      public void flatten_iterative(TreeNode root) {
	          if(root==null) return;
	          while(root!=null){
	              if(root.left!=null){
	                  if(root.right!=null){
	                      TreeNode tmp = root.left;
	                      while(tmp.right!=null){
	                          tmp = tmp.right;
	                      }
	                      tmp.right = root.right;
	                  }
	                  root.right = root.left;
	                  root.left = null;
	              }
	              root = root.right;
	          }
	      }
}
