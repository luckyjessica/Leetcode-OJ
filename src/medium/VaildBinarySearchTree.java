package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 * @author JieXu
 *
 */
public class VaildBinarySearchTree {
	// inorder,然后看是不是递增List
    // time o(N^2) space o(logn+n)
	// iterative method	
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = inorder(root);
        for(int i = 0 ; i<list.size()-1 ; i++){
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }
    public List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null){
            stack.push(root);
            root=root.left;
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
    
  //recursive,保存两个变量min和max，意为边界
    //注意不要用Max_integer, 如果Node的值正好为这两个边界就不行了
    // time o(n) space o(logn)
   public boolean isValidBST2(TreeNode root) {  
    return helper(root, null, null);   
   }  
   boolean helper(TreeNode root, Integer min, Integer max){    
       if(root == null)  return true;
       if((min!=null && root.val <= min )|| (max!=null && root.val >= max)) return false;
       return helper(root.left, min, root.val) && helper(root.right, root.val, max);  
}    
}
