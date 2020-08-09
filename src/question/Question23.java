package question;

/**
 * 链表中环的入口节点
 * 如果一个链表中包含环，如何找出入口节点
 * @author Administrator
 *
 */
public class Question23 {
	private class ListNode {
		public ListNode(int value) {
			this.value = value;
		}
		
		public int value;
		public ListNode next;
	}
	
	public ListNode findEntry(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode meetNode = meetNode(head);
		
		if (meetNode == null) {
			return null;
		}
		
		int distance = 0;
		
		ListNode findNode = meetNode;
		
		while (findNode.next != meetNode) {
			findNode = findNode.next;
			distance++;
		}
		
		ListNode fastNode = head;
		ListNode entry = head;
		
		for (int i = 0; i < distance; i++) {
			fastNode = fastNode.next;
		}
		
		while (fastNode.next != entry) {
			entry = entry.next;
			fastNode = fastNode.next;
		}
		
		return entry;
	}
	
	public ListNode meetNode(ListNode head) {
		ListNode fastNode = head;
		ListNode snowNode = head;
		
		while (fastNode.next != null) {
			snowNode = snowNode.next;
			fastNode = fastNode.next;
			
			if (fastNode.next != null) {
				fastNode = fastNode.next;
			} else {
				return null;
			}
			
			if (fastNode == snowNode) {
				break;
			}
		}
		
		if (fastNode.next == null) {
			return null;
		}
		
		return fastNode;
	}
	
	public void printNode(ListNode node) {
		if (node == null) {
			System.out.println("null");
		} else {
			System.out.println(node.value);
		}
	}
	
	public static void main(String[] args) {
		//问题1：
		Question23 q = new Question23();
		ListNode node = q.new ListNode(1);
		ListNode node1 = q.new ListNode(2);
		node.next = node1;
		ListNode node2 = q.new ListNode(3);
		node1.next = node2;
		ListNode node3 = q.new ListNode(4);
		node2.next = node3;
		ListNode node4 = q.new ListNode(5);
		node3.next = node4;
		node4.next = node2;
		q.printNode(q.findEntry(node));
	}
}
