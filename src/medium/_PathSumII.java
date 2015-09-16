package medium;
/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.ArrayList;
import java.util.List;

public class _PathSumII {
	 private List<List<Integer>> res = new ArrayList<List<Integer>>();
	   private List<Integer> onepath = new ArrayList<Integer>();
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        helper(root,sum);
	        return res;
	    }
	    public void helper(TreeNode root, int sum){
	        if(root==null) return;
	        
	        onepath.add(root.val);
	        if(root.val==sum && root.left==null && root.right==null){
	            res.add(new ArrayList<Integer>(onepath));
	        }
	        helper(root.left,sum-root.val);
	        helper(root.right,sum-root.val);
	        //这是为了把上一个加上去的不对的node减掉
	        onepath.remove(onepath.size()-1);
	    }
	    
}
