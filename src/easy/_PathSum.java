package easy;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * @author JieXu
 *Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 */
public class _PathSum {
	// depth first search
	public static boolean hasPath(TreeNode root,int sum){
		// 最深到leaf
		// 不要忘了考虑 sum是负数的情况
		if(root == null) return false;
		//跳出递归的情况，成功的情况，到达Leaf时剩余的数值正好是leaf的值
		if(sum==root.val && root.left==null && root.right==null) return true;
		return hasPath(root.left, sum - root.val) || hasPath(root.right,sum - root.val);
	}
}
