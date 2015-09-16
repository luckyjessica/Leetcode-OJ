package medium;
/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * @author JieXu
 *
 */
public class RotateList {
	    public static ListNode rotateRight(ListNode head, int k) {
	        if(head==null || head.next==null || k==0) return head;
	        ListNode fast = head;
	        ListNode slow = head;
	        int len = 1;
	        while(fast.next!=null){
	            fast = fast.next;
	            len++;
	        }
	        // n means how many nodes we should put to the tail after rotate
	        int n = len - k % len;
	        System.out.println(n);
	        if(n==len) return head;
	        while(n>1){
	            slow = slow.next;
	            n--;
	        }
	        //System.out.println(slow.val);
	        //System.out.println(len);

	        ListNode newhead = slow.next;
	        slow.next = null;
	        fast.next = head;
	        return newhead;
	    }
    public static void main(String[] args){
    	ListNode a = new ListNode(1);
    	a.next = new ListNode(2);
    	a.next.next = new ListNode(3);
    	System.out.println(rotateRight(a,2).next.val);
    }
}
