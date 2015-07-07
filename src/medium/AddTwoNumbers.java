package medium;
/**You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
class ListNode {
	    int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
	public static ListNode addTwo(ListNode l1, ListNode l2){
		if(l1==null||l2==null) return l1==null? l2:l1;
		ListNode l3 = new ListNode(-1);
		ListNode newhead = l3;
		int carry = 0;
		int sum = 0;
		while(l1!=null||l2!=null){
			if(l1!=null){
				sum += l1.val;
				l1=l1.next;
			}
			if(l2!=null){
				sum += l2.val;
				l2=l2.next;
			}
			newhead.next = new ListNode(sum%10);
			carry = sum/10;
			// 为下一位数的加法清零，只留进位
			sum = carry;
			newhead = newhead.next;
		}
		if(carry==1)newhead.next = new ListNode(1);
		return l3.next;
	}
	public static void main(String arg[]){
		ListNode a = new ListNode(8);
		ListNode c = new ListNode(9);
		a.next = c;
		ListNode d = new ListNode(9);
		c.next =d;
		ListNode b = new ListNode(2);
		System.out.println(addTwo(a,b).val);
	}
}
