package medium;
/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 * @author JieXu
 *
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) return null;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) break;
		}
		if(fast==null || fast.next==null) return null;
		
		ListNode p = head;
		while(p!=slow){
			p = p.next;
			slow = slow.next;
		}
		return p;	
    }
}
