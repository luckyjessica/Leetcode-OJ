package easy;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class RemoveLinkedListEle {
	public static ListNode Remove(ListNode head,int val){
		if(head==null) return null;
		ListNode fakehead = new ListNode(-1);
		fakehead.next = head;
		while(fakehead.next!=null){
			if(fakehead.next.val==val){
				ListNode t = fakehead.next;
				fakehead.next = fakehead.next.next;
				t.next = null;
			}
			else{
				fakehead = fakehead.next;
			}		
		}
		return fakehead.next;
	}
	public static void main(String arg[]){
	}

}
