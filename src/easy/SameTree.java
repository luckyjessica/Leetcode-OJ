package easy;
class TreeNode {
	  int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
public class SameTree {
	
   public static boolean isSameTree(TreeNode p, TreeNode q) {
       if(p==null&&q==null) return true;
       if(p!=null && q!=null && p.val==q.val){
    	   return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    	   }
       return false;
   }
}
