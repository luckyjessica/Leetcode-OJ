package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
 * @author JieXu
 *
 */


class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode(int x) { val = x; }
}

public class BinaryTreePostOrderTraversal {
	// iterative
    //Use a Stack: Time ~ O(N), Space ~ O(logN)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode tmp = stack.peek();
            //如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点）
            if(tmp.right!=null && pre != tmp.right){
                tmp = tmp.right;
                while(tmp!=null){
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }
            else{
                stack.pop();
                list.add(tmp.val);
                pre = tmp;
            }
           
        }
        return list;
    }
    public static void main(String[] args){
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		System.out.println(postorderTraversal(a));
	}
}
