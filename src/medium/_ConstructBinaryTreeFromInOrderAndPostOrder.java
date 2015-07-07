package medium;

import java.util.Arrays;
import java.util.HashMap;

/**Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * @author JieXu
 *
 */
/**
 假设一棵树，他的preorder是：1,2,4,3,5
他的inorder是：2,4,1,5,3


那么递归的看这个问题，首先preorder的第一个必然是根（1），然后此节点在inorder中的下标是2，
那么在inorder中，处于1之前的两个节点2,4是左子树的；反之5，3是右子树的。
针对左子树，2，4就是它的inorder，而在preorder中，除开第一个根，数两个节点的子序列正好是2，4，这是左子树的preorder。
这样这个问题就自然变成递归了：
即，其左子树的preorder是（2，4），inorder是（2，4）；类似有右子树preorder（3，5），inorder（5，3）。
然后边界情况是某数的preorder和inorder遍历的长度都是1，比如{x}，那么这棵树就是以x为值的节点。
 * @author JieXu
 *
 */
public class _ConstructBinaryTreeFromInOrderAndPostOrder {
	// 不断生成子数组，较占空间
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder.length==0 || postorder.length==0) return null;
    	TreeNode curr_root = new TreeNode(postorder[postorder.length-1]);
    	int position = findIdx(inorder,postorder[postorder.length-1]);
    	
    	int[] leftin = Arrays.copyOfRange(inorder, 0, position);
    	int[] rightin = Arrays.copyOfRange(inorder, position+1, inorder.length);
    	int[] leftpost = Arrays.copyOfRange(postorder, 0, position);
    	int[] rightpost = Arrays.copyOfRange(postorder, position, postorder.length-1);
    	
    	curr_root.left = buildTree(leftin, leftpost);
    	curr_root.right = buildTree(rightin, rightpost);
    	
        return curr_root;
    }
    public static int findIdx(int[] a,int val){
        for(int i=0;i<a.length;i++){
            if(a[i] == val){
                return i;
            }
        }
        return -1;
        }
    //优化版本 Time O(n) every node pass one time
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
    	if(inorder.length==0 || postorder.length==0) return null;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	// 因为没有重复值，所以可以把值当成Key
    	for(int i = 0 ; i < inorder.length ; ++i){
		map.put(inorder[i], i);
		}

    	return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1, map);
    }
    public static TreeNode helper(int[]inorder, int[]postorder, int InStart,int InEnd, int PostStart, int PostEnd, HashMap<Integer,Integer> map){
    	// base case
    	if(InStart>InEnd || PostStart>PostEnd) return null;
    	
    	int position = map.get(postorder[PostEnd]);
    	//左孩子的长度
    	int leftlen = position - InStart;
    	//右孩子的长度
    	int rightlen = InEnd - position;
    	TreeNode curr_root = new TreeNode(postorder[PostEnd]);
    	//各个起点终点要搞清楚！！！！！！
        curr_root.left = helper(inorder,postorder,InStart,position-1,PostStart,PostStart+leftlen-1,map);
        curr_root.right = helper(inorder,postorder,position+1,InEnd,PostEnd-rightlen,PostEnd-1,map);
        return curr_root;

    }
}
