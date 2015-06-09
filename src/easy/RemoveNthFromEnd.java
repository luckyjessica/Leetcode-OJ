package easy;

public class RemoveNthFromEnd {
	public static ListNode removenth(ListNode head,int n){
		// slow.next is the element need to be removed.
		ListNode fast = head;
		ListNode slow = head;
		
		for(int i=1;i<=n;i++){
			fast = fast.next;
			// fast arrive the tail.next == null
			if(fast == null) {
				// the head node is removed
				if(i == n) return head.next;
				// int n bigger than the length of the list
				else return null;
			}
		}
		
		while(fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		System.out.println(slow.val);
		slow.next = slow.next.next;
		return head;
	}
	public static void main(String arg[]){

	}
}
