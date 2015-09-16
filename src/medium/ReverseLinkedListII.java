package medium;
/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
 * @author JieXu
 *
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head==null || head.next==null || m==n ) return head;
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode pre = dummy;
    	// cura表示已被旋转的那段的最前面的node
    	ListNode curb = head;
    	// curb表示已被旋转的那段的最后面的Node，一旦定了就不会动态改变的，只会不断改next指针
    	ListNode cura = head;
    	int delta = n-m;
    	//先移到要旋转的 cur指向第一个Node
    	while(m>1 && curb!=null){
    		pre = cura;
    		curb = curb.next;
    		cura = cura.next;
    		m--;
    	}
    	while(delta>0){
    		System.out.println(pre.val);
        	System.out.println(curb.val);
    		ListNode tmp = curb.next;
    		curb.next = tmp.next;
    		pre.next = tmp;
    		tmp.next = cura;
    		cura = pre.next;
    		delta--;
    	}
    	return dummy.next;
    }
    
    public static void main(String[] args){
    	ListNode a = new ListNode(1);
    	a.next = new ListNode(2);
    	a.next.next = new ListNode(3);
    	a.next.next.next = new ListNode(4);
    	//a.next.next.next.next = new ListNode(5);

    	System.out.println(reverseBetween(a,1,4).next.next.val);
    }
}
