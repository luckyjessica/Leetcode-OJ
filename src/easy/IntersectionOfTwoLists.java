package easy;
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

* Notes:

!! If the two linked lists have no intersection at all, return null.
!! The linked lists must retain their original structure after the function returns.
!! You may assume there are no cycles anywhere in the entire linked structure.
!! Your code should preferably run in O(n) time and use only O(1) memory.
 * @author JieXu
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * @author JieXu
 *
 */
public class IntersectionOfTwoLists {
	public static ListNode intersection(ListNode headA, ListNode headB){
		if(headA == null || headB ==null) return null;
		ListNode pA = headA;
		ListNode pB = headB;
		int lengthA = 0,lengthB = 0;
		//get the length of two lists
		while(pA!=null){
			pA = pA.next;
			lengthA++;
		}
		while(pB!=null){
			pB = pB.next;
			lengthB++;
		}
		//reset two pointers
		pA = headA;
		pB = headB;
		// get the delta of length
		int delta = lengthA > lengthB ? lengthA - lengthB : lengthB - lengthA;
		// move the delta steps of the longer lists
		if(lengthA > lengthB){
			while(delta > 0){
				pA = pA.next;
				delta--;
			}
		}
		else{
			while(delta > 0){
				pB = pB.next;
				delta--;
			}
		}
		// right now the two pointers are same steps away from the intersection node
		while(pA!=null){
			if(pA!= pB){
				pA = pA.next;
				pB = pB.next;
			}
			else return pA;
		}
		return null;
	}
}
