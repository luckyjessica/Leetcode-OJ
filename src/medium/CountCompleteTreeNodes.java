package medium;
/**Given a complete binary tree, count the number of nodes.
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
 *  It can have between 1 and 2h nodes inclusive at the last level h.
 * @author JieXu
 *
 */
//O(logn*logn)
//思路：if left subtree is complete, the right one is full, if left is full, right is complete
// so the depth of this two subtree is either same or left bigger than right
public class CountCompleteTreeNodes {
	public static int countNodes(TreeNode root){
		int count = 0;
		if(root==null) return 0;
		int LeftHalfLevel = getLevel(root.left);
		int RightHalfLevel = getLevel(root.right);
		if(LeftHalfLevel>RightHalfLevel){
			count = (1<<RightHalfLevel) + countNodes(root.left);
		}
		else{
			count = (1<<LeftHalfLevel) + countNodes(root.right);
		}
		return count;
	}
	public static int getLevel(TreeNode root){
		if(root==null) return 0;
		int level = 0;
		while(root!=null){
			level++;
			root=root.left;
		}
		return level;
	}
	
	public static void main(String arg[]){
		TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(countNodes(root));
	}
}
