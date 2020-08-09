package question;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 * @author Administrator
 *
 */
public class Question25 {
	private class ListNode {
		public ListNode(int value) {
			this.value = value;
		}
		
		public int value;
		public ListNode next;
	}
	
	public void printList(ListNode head) {
		int count = 1;
		
		if (head != null) {
			System.out.print(head.value);
			count++;
		}
		
		ListNode node = head.next;
		
		while(node != null) {
			System.out.print("->" + node.value);
			node = node.next;
			count++;
		}
		
		System.out.println();
	}
	
	public ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		} else if (head2 == null){
			return head1;
		}
		
		ListNode mergeHead = null;
		
		if (head1.value <= head2.value) {
			mergeHead = head1;
			mergeHead.next = merge(head1.next, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = merge(head1, head2.next);
		}
		
		return mergeHead;
	}
	
	public static void main(String[] args) {
		//问题1：
		Question25 q = new Question25();
		ListNode node = q.new ListNode(1);
		ListNode node1 = q.new ListNode(3);
		node.next = node1;
		ListNode node2 = q.new ListNode(5);
		node1.next = node2;
		ListNode node3 = q.new ListNode(7);
		node2.next = node3;
		
		ListNode node_2 = q.new ListNode(2);
		ListNode node1_2 = q.new ListNode(4);
		node_2.next = node1_2;
		ListNode node2_2 = q.new ListNode(6);
		node1_2.next = node2_2;
		ListNode node3_2 = q.new ListNode(8);
		node2_2.next = node3_2;
		
		q.printList(node);
		q.printList(node_2);
		q.printList(q.merge(node, node_2));
	}
}
