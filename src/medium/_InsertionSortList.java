package medium;
/**
 * Sort a linked list using insertion sort.
 * @author JieXu
 *
 */
public class _InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode resdummy = new ListNode(-1);
        ListNode ptr = head;
        while(ptr!=null){
        	ListNode next = ptr.next;
        	ListNode pre = resdummy;
        	while(pre.next!=null && ptr.val>=pre.next.val){
        		pre = pre.next;
        	}
        	ptr.next = pre.next;
        	pre.next = ptr;
        	ptr = next;
        }
        return resdummy.next;
    }
	public static void main(String[] args){
		ListNode a = new ListNode(6);
		a.next = new ListNode(5);
		a.next.next = new ListNode(4);
		System.out.println(insertionSortList(a).val);
	}
}
