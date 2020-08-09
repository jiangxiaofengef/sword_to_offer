package question;

/**
 * 
 * @author Administrator
 *
 */
public class Question18 {
	private class ListNode {
		public ListNode(int value) {
			this.value = value;
		}
		
		public int value;
		public ListNode next;
	}
	
	public static void printNode(ListNode head) {
		int count = 1;
		
		if (head != null) {
			System.out.print(count + ":" +  head.value);
			count++;
		}
		
		ListNode node = head.next;
		
		while(node != null) {
			System.out.print("->" + count + ":" +  node.value);
			node = node.next;
			count++;
		}
		
		System.out.println();
	}
	
	/**
	 * 问题1：在O(1)时间内删除链表节点
	 * 给定单向链表的头指针和一个节点的指针，定义一个函数在O(1)时间内删除该节点。
	 * @param head
	 * @param delete
	 * @return
	 */
	public static ListNode deleteNode(ListNode head, ListNode delete) {
		if (head != null && delete != null) {
			if (delete == head) {
				head = delete.next;
			} else {
				if (delete.next != null) {
					delete.value = delete.next.value;
					delete.next = delete.next.next;
				} else {
					ListNode p = head;
					
					while (p.next != null && p.next != delete) {
						p = p.next;
					}
					
					p.next = null;
				}
			}
		}
		
		return head;
	}
	
	/**
	 * 问题2：删除链表中重复的节点
	 * 在一个排序的链表中，如何删除重复的节点
	 * @param head
	 */
	public static ListNode deleteDuplication(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode preNode = null;
		ListNode node = head;
		
		while (node != null &&  node.next != null) {
			if (node.value != node.next.value) {
				preNode = node;
				node = node.next;
			} else {
				ListNode next = node.next;
				
				while (next.next != null && next.value == next.next.value) {
					next = next.next;
				}
				
				if (preNode == null) {
					head = next.next;
					node = next.next;
				} else {
					preNode.next = next.next;
					node = next.next;
				}
			}
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		//问题1：
		Question18 q = new Question18();
		ListNode node = q.new ListNode(1);
		ListNode node1 = q.new ListNode(2);
		node.next = node1;
		ListNode node2 = q.new ListNode(3);
		node1.next = node2;
		ListNode node3 = q.new ListNode(4);
		node2.next = node3;
		ListNode node4 = q.new ListNode(5);
		node3.next = node4;
		Question18.printNode(node);
		Question18.printNode(Question18.deleteNode(node, node4));
		
		//问题2
		ListNode node_q2 = q.new ListNode(2);
		ListNode node1_q2 = q.new ListNode(2);
		node_q2.next = node1_q2;
		ListNode node2_q2 = q.new ListNode(2);
		node1_q2.next = node2_q2;
		ListNode node3_q2 = q.new ListNode(4);
		node2_q2.next = node3_q2;
		ListNode node4_q2 = q.new ListNode(5);
		node3_q2.next = node4_q2;
		Question18.printNode(node_q2);
		Question18.printNode(Question18.deleteDuplication(node_q2));
	}
}
