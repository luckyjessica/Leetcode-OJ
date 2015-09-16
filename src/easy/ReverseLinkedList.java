package easy;

public class ReverseLinkedList {
	/** A => B => C => D
	 *  newhead = D => null
	 *  A => B => C => D => C
	 *  A => B => C => null 
	 *  newhead = D => C
	 *  A => B => C => B
	 *  newhead = D => C = >B
	 * @param head
	 * @return
	 */
    public static ListNode recursively(ListNode head) {
    	//check if we reach the end of the list
    	//end of recursion
    	if(head == null || head.next==null) return head;
    	// get the current new list
    	ListNode newhead = recursively(head.next);
    	// C - D - C
    	head.next.next = head;
    	head.next = null;

    	return newhead;
    	}
    
    public static ListNode iterative(ListNode head){
    	if(head == null || head.next == null) return head;
    	ListNode pre = null;
    	ListNode cur = head;
    	ListNode tmp;
    	while(cur != null){
    		tmp = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = tmp;
    	}
    	return pre;
    }
    
    public static void main(String arg[]){
    	int[] a = {1,2,3,4};
    	ListNode A =new ListNode(4);
    	ListNode B =new ListNode(9);
    	ListNode C =new ListNode(3);
    	ListNode D =new ListNode(6);
    	A.next=B;
    	B.next=C;
    	C.next=D;
    	D.next=null;
    	ListNode pointer = A;
    	while(pointer.next!=null){
    		System.out.print(pointer.val + " => ");
    		pointer = pointer.next;
    	}
    	System.out.println(D.val);
    	
    	ListNode list = recursively(A);
    	while(list!=null){
    		System.out.print(list.val + " => ");
    		list = list.next;
    	}
    }
}
