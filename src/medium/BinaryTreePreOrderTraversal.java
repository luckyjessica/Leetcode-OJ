package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
 * @author JieXu
 *
 */
public class BinaryTreePreOrderTraversal {
	// iterative
    // 和inorder几乎一样，就是list加的位置不同
	// time o(n), space 栈的o(logn)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        list.
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null){
            stack.push(root);
            list.add(root.val);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            tmp = tmp.right;
            while(tmp!=null){
                stack.push(tmp);
                list.add(tmp.val);
                tmp = tmp.left;
            }
        }
        return list;
    }
}
