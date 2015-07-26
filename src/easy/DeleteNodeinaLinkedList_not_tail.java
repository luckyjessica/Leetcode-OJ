package easy;
/**Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * 
 * @author JieXu
 *
 */
public class DeleteNodeinaLinkedList_not_tail {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
