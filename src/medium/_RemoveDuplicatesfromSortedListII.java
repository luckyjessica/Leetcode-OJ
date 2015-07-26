package medium;
/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * @author JieXu
 *
 */
public class _RemoveDuplicatesfromSortedListII {
	// two pointers
	public static ListNode deleteDuplicates(ListNode head) {
		 if(head==null || head.next==null) return head;
	        ListNode dummy = new ListNode(-1);
	        dummy.next = head;

	        ListNode pre = dummy;
	        ListNode cur = pre.next;
	        
	        while(cur!=null){
	        	while(cur.next!=null && cur.val == cur.next.val){
	        		cur = cur.next;
	        	}
	        	//接连两个不重复
	        	if(pre.next==cur){
	        		pre = pre.next;
	        	}
	        	//有重复
	        	else{
	        		pre.next = cur.next;
	        	}
	        	cur = cur.next;
		        System.out.println("head "+head.val);
		        System.out.println("dummy " + dummy.val);
		        System.out.println("dummy.next "+dummy.next.val);
		        System.out.println("pre "+pre.val);
		        System.out.println();
	        }

	        return dummy.next;
	}
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		a.next = new ListNode(1);
		a.next.next = new ListNode(2);
		a.next.next.next = new ListNode(3);
		a.next.next.next.next = new ListNode(3);
		ListNode res = deleteDuplicates(a);
		while(res!=null){
			System.out.println(res.val+"->");
			res = res.next;
		}
	}
}
