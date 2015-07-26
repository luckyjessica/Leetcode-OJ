package medium;

import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 * @author JieXu
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
	// time o(N) space o(n)
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        //因为没有重复值，可以把node的值当做key
        // node的值为key, index为value
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,inorder.length-1,0,preorder.length-1,map);
    }
    public TreeNode build(int[] preorder,int[]inorder,int ileft,int iright,int pleft,int pright,HashMap<Integer,Integer> map){
        //base case
        if(ileft>iright || pleft>pright) return null;
        //get root position in inorder traversal
        int position = map.get(preorder[pleft]);
        TreeNode curr_root = new TreeNode(preorder[pleft]);
        int leftlen = position-ileft;
        int rightlen = iright-position;
        //各个index一定要搞清楚
        curr_root.left = build(preorder,inorder,ileft, position-1,pleft+1,pleft+leftlen,map);
        curr_root.right = build(preorder,inorder,position+1,iright,pright-rightlen+1,pright,map);
        return curr_root;
    }
}
