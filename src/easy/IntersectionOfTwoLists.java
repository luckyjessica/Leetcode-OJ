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
		if(headA==null || headB==null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1= 0, len2 = 0;
        while(p1!=null){
            len1++;
            p1 = p1.next;
        }
        while(p2!=null){
            len2++;
            p2=p2.next;
        }
        int delta = len1-len2;
        while(delta > 0){
            headA = headA.next;
            delta--;
        }
        while(delta < 0){
            headB = headB.next;
            delta++;
        }
        while(headA!=null && headB!=null){
            if(headA==headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
	}
}
