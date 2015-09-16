package hard;
/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * @author JieXu
 *
 */
public class BinaryTreeMaximumPathSum {
	/**
     * DFS: Time ~ O(N), Space ~ O(logN) 
     * 注意此题不同于上面两题，path可以从任何节点开始、任何节点结束。
     * 用maxSum记录最大的path长度，在每个节点求得其左子树和右子树的maxPath = left and rigth，
     * 若为正则和该node的val一起相加，在与maxSum比较：
     * maxSum = max{x.val + left + right, maxSum};
     * 递归函数则返回左右子树最大的一侧path，再加上该node的val：
     * ret = x.val + max{left, right};
     * 如果ret为负，则返回0。
     **/
// Bottom-up
// maxSum: store the max at current node
// ret: store the max from current node to its one side, used to calculate its parent's maxSum 
private int maxSum;

public int maxPathSum(TreeNode root) {
    maxSum = Integer.MIN_VALUE;
    findMax(root);
    return maxSum;
}

private int findMax(TreeNode curr) {
    if (curr == null)  return 0;
    int left = findMax(curr.left);
    int right = findMax(curr.right);
    maxSum = Math.max(curr.val + left + right, maxSum);
    int ret = curr.val + Math.max(left, right);
    return (ret > 0) ? ret : 0;
}
}
