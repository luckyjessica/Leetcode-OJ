package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author JieXu
 *
 */
// 加一个flag判断奇数偶数行,从而决定是否要reverse当前行
//增加一个判断当前行数的flag,如果是奇数行，那么当前行不用翻转，如果偶数，往list里添加元素的时候像stack那样，加在头上
// time o(n),space o(n)
public class BinaryTreeZigzagLevelOrderTraversal {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return list;
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> onelevel = new ArrayList<Integer>();
            while(count>0){
                TreeNode tmp = queue.poll();
                if(flag){
                    onelevel.add(0,tmp.val);
                } 
                else{
                    onelevel.add(tmp.val);
                }
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
               count--;
            }
            flag = !flag;
            list.add(onelevel);
        }
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
		System.out.println(zigzagLevelOrder(a));
	}
}
