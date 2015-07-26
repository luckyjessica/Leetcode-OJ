package easy;
/**
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author JieXu
 *
 */

// 不要用stack，直接reverse后半段, time O(n), space O(1)
public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head){
		if(head==null || head.next==null) return true;
		if(head.next.next==null && head.val == head.next.val )
			return true;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode reversehead = reversehalf(slow);
		// 如果node数是偶数，前半段还是连着后半段的第一个，所以是reverse那半先到达null
		// 1->2->2->1
		// slow = 2, 
		// 1->2->2->null
		//       ^      
		//       1
		//       
		//       
		while(head !=null && reversehead!=null){
			if(head.val != reversehead.val) return false;
			head = head.next;
			reversehead = reversehead.next;
		}
		return true;
	}
	public static ListNode reversehalf(ListNode head){
		ListNode pre = null;
		while(head!=null){
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		System.out.println(pre.val);

		return pre;
	}
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(2);
		a.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(a));
	}
}
