package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * public List<List<Integer>> levelOrder(TreeNode root) {

    ArrayList<List<Integer>> l=new ArrayList<List<Integer>>();

    addLevel(l,0,root);

    return l;

}

private void addLevel(List<List<Integer>> l, int level, TreeNode root){

    if(root==null) return;

    if(l.size()==level) l.add(new ArrayList<Integer>());

    l.get(level).add(root.val);

    addLevel(l,level+1,root.left);

    addLevel(l,level+1,root.right);
}

 * @author JieXu
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelorder = new ArrayList<List<Integer>>();
		List<Integer> onelevel = new ArrayList<Integer>();
		
		if(root == null) return levelorder;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		int count = 1;
		while(!queue.isEmpty()){
			count = queue.size();
			// poll - return and remove
			while(count>0){
				TreeNode tmp = queue.poll();
				onelevel.add(tmp.val);
				if(tmp.left!=null) queue.add(tmp.left);
				if(tmp.right!=null) queue.add(tmp.right);
				count--;
			}
			levelorder.add(onelevel);
			onelevel = new ArrayList<Integer>();
		}
		return levelorder;
	}
	public static void main(String arg[]){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		
		a.left = b;
		a.right = c;
		b.left = d;
		System.out.println(levelOrder(a));
	}
}
