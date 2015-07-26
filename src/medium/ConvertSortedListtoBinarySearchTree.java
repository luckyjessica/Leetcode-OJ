package medium;
/**Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author JieXu
 *
 */
/**
 * /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListtoBinarySearchTree {
	// in-order反向操作,会破坏list的结构
	public static TreeNode sortedListToBST(ListNode head){
		if(head==null) return null;
		if(head.next==null) return new TreeNode(head.val);
		
		ListNode mid = whatismid(head);
		TreeNode root = new TreeNode(mid.val);
		
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}
	public static ListNode whatismid(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		ListNode tmp = head;
		while(fast!=null && fast.next!=null){
			tmp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//把两半链表断开
		tmp.next = null;
		return slow;
	}
	
	
	 //方法2：Bottom-up
    //先构建 leftSubTree = sortedListToBST(start, mid - 1)（注意：完成后 list会自动移到 mid处）；
    //将 mid 的值存入 parent 中，并将 list 前移一格；
    //再构建 rightSubTree = sortedListToBST(mid + 1, end)。
    private ListNode list;  
    public TreeNode sortedListToBST2(ListNode head) {        
    int len = 0;  // size of the list
    ListNode p = head;
    while (p != null) {
        len++;
        p = p.next;
    }
    list = head;
    return sortedListToBST(0, len - 1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end)    return null;
        int mid = (start + end) / 2;
        //注意：这步完成后 list会自动移到 mid处
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(list.val);
        root.left = leftChild;
        list = list.next;
        root.right = sortedListToBST(mid + 1, end);
        return root;
    }
}

