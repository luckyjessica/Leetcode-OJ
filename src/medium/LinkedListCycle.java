package medium;
/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
 * @author JieXu
 *
 */
// two pointer的经典用法，cc150里也有
// time o(n), space o(1)
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null || (head.next!=null && head.next.next==null)) return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow) return true;
        }
        return false;
    }
}
