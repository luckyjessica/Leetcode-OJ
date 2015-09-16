package medium;
/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * @author JieXu
 *
 */
public class PartitionList {
	//新建了链表
	public ListNode partition(ListNode head, int x) {
		if(head==null||head.next==null) return head;
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-2);
		ListNode p1 = dummy1;
		ListNode p2 = dummy2;
		while(head!=null){
			if(head.val<x){
				p1.next = new ListNode(head.val);
				p1 = p1.next;
			}
			else{
				p2.next = new ListNode(head.val);
				p2 = p2.next;
			}
			head = head.next;
		}
		p1.next = dummy2.next;
		return dummy1.next;
	}
	//这里就不新建链表了，而是不断往后接，注意和上面那个方法的对比
	//但是多了一步最后把p2.next == null，自己体会
	// time o(n) space o(1)
	public ListNode partition2(ListNode head, int x) {
		if(head==null||head.next==null) return head;
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-2);
		ListNode p1 = dummy1;
		ListNode p2 = dummy2;
		while(head!=null){
			if(head.val<x){
				p1.next = head;
				p1 = p1.next;
			}
			else{
				p2.next = head;
				p2 = p2.next;
			}
			head = head.next;
		}
		//注意这步
		p2.next = null;
		p1.next = dummy2.next;
		return dummy1.next;
	}
}
