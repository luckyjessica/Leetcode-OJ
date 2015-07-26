package medium;
/**Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author JieXu
 *
 */
public class ConvertSortedArraytoBinarySearchTree {
	//不断找中点，当left>right的时候，跳出递归
	 public TreeNode sortedArrayToBST(int[] nums) {
	        return helper(nums, 0 , nums.length-1);      
	    }
	    public TreeNode helper(int[]nums, int start, int end){
	        if(start>end) return null;
	        int mid = (start+end)/2;
	        TreeNode root = new TreeNode(nums[mid]);
	        root.left = helper(nums, start, mid-1);
	        root.right = helper(nums, mid+1, end);
	        return root;
	    }
}
