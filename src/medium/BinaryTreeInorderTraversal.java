package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author JieXu
 *
 */
public class BinaryTreeInorderTraversal {
	// recursive method
	// T O(n)  ， S  递归栈的大小 O(Logn)
	public static List<Integer> recursiveinorder(TreeNode root){
		LinkedList<Integer> list = new LinkedList<Integer>();	
		return inorder(root,list);
	}
	
	public static List<Integer> inorder(TreeNode root, List<Integer> list){
		if(root==null) return list;
		inorder(root.left,list);
		list.add(root.val);
		inorder(root.right,list);
		return list;
	}
	
	//iterative method
	//不断断开Binary tree里的Node，但是这样会改变
	public static List<Integer> iterativeinorder(TreeNode root){
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(root==null) return list;
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tmp = stack.pop();
			if(tmp.left==null && tmp.right==null) list.add(tmp.val);
			else{
				if(tmp.right!=null){
					stack.push(tmp.right);
					//断开Node！！这样最后才能加入List
					tmp.right=null;
				}
				stack.push(tmp);
				if(tmp.left!=null){
					stack.push(tmp.left);
					tmp.left=null;
				}
			}
		}
		return list;
	}
	//iterative, 不破坏树的
	// time o(n),space o(logn)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            tmp = tmp.right;
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return list;
    }
	public static void main(String[] args){
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		System.out.println(iterativeinorder(a));
	}
}
