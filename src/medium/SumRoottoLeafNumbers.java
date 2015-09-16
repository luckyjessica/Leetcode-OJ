package medium;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * @author JieXu
 *
 */
//进行递归，最终把左右子树的总和相加。
//结束条件的话就是如果一个节点是叶子，那么我们应该累加到结果总和中，
//如果节点到了空节点，则不是叶子节点，不需要加入到结果中，直接返回0即可。
public class SumRoottoLeafNumbers {
	// time o(n) space o(logn)
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root, int sum){
        //base case
        if(root==null) return 0;
        //如果到了leaf node, 返回给上级function
        if(root.left==null && root.right==null) return sum*10+root.val;
        return helper(root.left,sum*10+root.val) + helper(root.right,sum*10+root.val);
    }
}
