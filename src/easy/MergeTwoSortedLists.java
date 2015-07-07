package easy;
/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author JieXu
 *
 */
public class MergeTwoSortedLists {
	// create a new list
	public static ListNode mergesorted(ListNode l1,ListNode l2){
		if(l1==null || l2==null) return l1==null? l2 : l1;
		ListNode dummy = new ListNode(0);
        ListNode answer = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
            	answer.next = l2;
                l2 = l2.next;
            } else {
            	answer.next = l1;
                l1 = l1.next;
            }
            answer = answer.next;
        }
        answer.next = l1 == null ? l2 : l1;
        return dummy.next;
	}
	// doesn't create new list
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null || l2==null) return l1==null? l2 : l1;
		ListNode dummy = new ListNode(0);
		dummy.next = l1;
	    ListNode p1 = dummy;
	    ListNode p2 = l2; 
	   
		while(p1.next!=null && p2!=null){
	    	if(p2.val<p1.next.val){
	    		// two reference to that node
	    		//!!!!!!! 注意顺序！！
	    		ListNode t = p2;
	    		p2 = p2.next;
	    		t.next = p1.next;
	    		p1.next = t;
	    		p1 = p1.next;
	    		//System.out.print(p2.val);
	    	}
	    	else{
	    		p1 = p1.next;
	    	}
	    }
		// if p1 reach the end ,but p2 not, just add the left in p2 to p1's tail
	    if(p1.next == null && p2!=null) p1.next = p2;
	    
	    return dummy.next;
	}
	public static void main(String arg[]){
		System.out.println(2+ "==");
		System.out.print(1+ "==");
		System.out.println(3+ "==");
		ListNode a = new ListNode(1);
		a.next = new ListNode(3);
		a.next.next = new ListNode(5);
		ListNode t = mergeTwoLists(new ListNode(2), a);
		while(t != null ){			
			System.out.print(t.val+"==");
			t = t.next;
		};
	}
	
}
