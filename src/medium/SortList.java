package medium;
/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

/**
 * 考虑到要求用O(nlogn)的时间复杂度和constant space complexity来sort list，自然而然想到了merge sort方法。
 * 同时我们还已经做过了merge k sorted list和merge 2 sorted list。这样这个问题就比较容易了。
 * 不过这道题要找linkedlist中点，那当然就要用最经典的faster和slower方法
 * @author JieXu
 *
 */

//模拟出一颗二叉树来，每一层的总计算量是O(n)的，总的层数是O(logn)的，所以总的复杂度是nlogn

public class SortList {
	// 先把list一分二再分二，直到lefthalf和righthalf都只有一个Node
	// 把这两个node按照mergesort排序一下，返回，
	// 下两个node再排序一下，返回，
	// lefthalf和righthalf变成两个Node，继续递归
	public static ListNode sortList(ListNode head){
		if(head==null || head.next==null) return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode tmp = head;
		while(fast!=null && fast.next!=null){
			tmp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		tmp.next = null;

		ListNode lefthalf= sortList(head);
		ListNode righthalf = sortList(slow);
		
		return mergetwosortedlist(lefthalf,righthalf);
	}
	public static ListNode mergetwosortedlist(ListNode left,ListNode right){
		if(left==null) return right;
		if(right==null) return left;
		
		//以left作为base,把right的node向里插
		ListNode dummy = new ListNode(-1);
		dummy.next = left;
		ListNode pointer = dummy;
		
		while(pointer.next!=null && right!=null){
			if(left.val>right.val){
				ListNode tmp = right;
				right = right.next;
				tmp.next = pointer.next;
				pointer.next = tmp;				
			}
			else{
				left = left.next;
			}
			pointer = pointer.next;
		}
		if(right!=null){
			pointer.next = right; 
		}
		if(left!=null){
			pointer.next = left;
		}
		return dummy.next;
	}
	public static void main(String arg[]){
		ListNode a = new ListNode(1);
		a.next = new ListNode(5);
		a.next.next = new ListNode(3);
		ListNode t = sortList(a);
		while(t != null ){			
			System.out.print(t.val+"==");
			t = t.next;
		};
	}
}
