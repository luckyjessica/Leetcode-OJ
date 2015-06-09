package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author JieXu
 *
 */
public class RemoveDuplicatesfromSortedList {
	// SORTED!!!!!
	// create new list, O(N) time
	public static ListNode deleteDuplicates(ListNode head){
		if(head==null) return head;
		ListNode newhead = new ListNode(head.val);
		ListNode p2 = newhead;
		ListNode pointer = head;
		while(pointer!=null){
			if(pointer.val != p2.val){
				p2.next = new ListNode(pointer.val);
				p2 = p2.next;			
			}
			pointer = pointer.next;
		}
		return newhead;
	}
	// in space
	public static ListNode deleteinspace(ListNode head){
		if(head==null || head.next == null) return head;
		ListNode fast = head;
		ListNode fake = new ListNode(0);
		fake.next = head;
		while(fast.next!=null){
			if(fast.val==fast.next.val){
				fast.next = fast.next.next;
			}
			else fast = fast.next;
		}
		return fake.next;
	}
	public static void main(String arg[]){
    	ListNode A =new ListNode(1);
    	ListNode B =new ListNode(1);
    	ListNode C =new ListNode(6);
    	ListNode D =new ListNode(9);
    	
    	A.next=B;
    	B.next=C;
    	C.next=D;
    	D.next=null;
    	System.out.println(deleteinspace(A));
	}
}
