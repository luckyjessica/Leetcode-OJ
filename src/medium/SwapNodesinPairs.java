package medium;
/**Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
**/
public class SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
    	if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while(cur!=null && cur.next!=null){
        	ListNode tmp= cur.next;
        	//dummy要不断指向头node
            pre.next= tmp;
            cur.next= tmp.next;
            tmp.next= cur;
            pre = cur;
            cur= cur.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
    	ListNode a = new ListNode(1);
    	a.next = new ListNode(2);
    	System.out.println(swapPairs(a).val);
    	
    }
}
