package medium;
/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author JieXu
 *
 */
// 分成两半
// 第二半翻转
// 两部分合并
// time o(n) space o(1)
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) return;
		ListNode slow = head;
		ListNode fast = head;
		//两种情况，奇数个或者偶数个Node
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			//偶数个Node的情况
			if(fast==null){
				break;
			}
			slow = slow.next;
		}
		//链表断开，p2是后半部分的头Node
		ListNode p2 = slow.next;
		slow.next = null;
		
		//逆转p2,不用dummy
		ListNode pre = null;
		ListNode cur = p2;
		while(cur!=null){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		//插入
		p2 = pre;
		ListNode p1 = head;
		while(p2!=null){
			ListNode tmp = p1.next;
			p1.next = p2;
			p2 = p2.next;
			p1.next.next = tmp;
			p1 = tmp;
		}
	}
}
