package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	//iterative time o(n), space o(logn)
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> onelevel = new ArrayList<Integer>();
		if(root==null) return result;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		int count;
		while(!queue.isEmpty()){

			count = queue.size();
			while(count>0){
				TreeNode tmp = queue.poll();
				onelevel.add(tmp.val);
				
				if(tmp.left!=null) queue.add(tmp.left);
				if(tmp.right!=null) queue.add(tmp.right);
				count--;
			}
		//注意这个方法！！！一直往前加
		result.add(0, onelevel);;
		onelevel = new ArrayList<Integer>();
		}
		return result;
	}
	
	public static void main(String arg[]){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		
		a.left = b;
		a.right = c;
		b.left = d;
		System.out.println(levelOrderBottom(a));
	}
}
