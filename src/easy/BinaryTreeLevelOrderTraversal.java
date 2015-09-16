package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


 * @author JieXu
 *
 */
public class BinaryTreeLevelOrderTraversal {
	//iterative BFS
	// 时间复杂度为结点的数量，O(n)，空间复杂度是一层的结点数，也是O(n)
	public static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> levelorder = new ArrayList<List<Integer>>();
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	        
	        if(root==null) return levelorder;
	        queue.add(root);
	        
	        while(!queue.isEmpty()){
	            int count = queue.size();
	            List<Integer> onelevel = new ArrayList<Integer>();
	            while(count>0){
	                TreeNode tmp = queue.poll();
	                onelevel.add(tmp.val);
	                if(tmp.left!=null) queue.add(tmp.left);
	                if(tmp.right!=null) queue.add(tmp.right);
	                count--;
	            }
	            levelorder.add(onelevel);
	        }
	        return levelorder;
	}
	//recursive
	// DFS
	// time o(N^2) space o(logn) 递归栈
    public static List<List<Integer>> iterative(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        return addlevel(root,0,list);
    }
    public static List<List<Integer>> addlevel(TreeNode root, int level, List<List<Integer>> list){
        if(root==null) return list;
        System.out.println(list);
        //size=1,level = 2
        // level从0开始
        //判断是否是新的一level开始
        if(list.size()==level){
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        addlevel(root.left,level+1,list);
        addlevel(root.right,level+1,list);
        return list;
    }
    
	public static void main(String arg[]){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		
		a.left = b;
		a.right = c;
		b.left = d;
		System.out.println(iterative(a));
	}
}
