package question;

/**
 * 链表中的倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * @author Administrator
 *
 */
public class Question22 {
	private class ListNode {
		public ListNode(int value) {
			this.value = value;
		}
		
		public int value;
		public ListNode next;
	}
	
	public ListNode findKthToTail(ListNode head, int k) {
		if (k <= 0 || head == null) {
			return null;
		}
		
		ListNode kNode = head;
		
		for (int i = 1; i < k; i++) {
			if (kNode.next != null) {
				kNode = kNode.next;
			} else {
				return null;
			}
		}
		
		ListNode node = head;
		
		while (kNode.next != null) {
			kNode = kNode.next;
			node = node.next;
		}
		
		return node;
	}
	
	public void printNode(ListNode node) {
		if (node == null) {
			System.out.println("null");
		} else {
			System.out.println(node.value);
		}
	}
	
	public void printList(ListNode head) {
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
	
	public static void main(String[] args) {
		//问题1：
		Question22 q = new Question22();
		ListNode node = q.new ListNode(1);
		ListNode node1 = q.new ListNode(2);
		node.next = node1;
		ListNode node2 = q.new ListNode(3);
		node1.next = node2;
		ListNode node3 = q.new ListNode(4);
		node2.next = node3;
		ListNode node4 = q.new ListNode(5);
		node3.next = node4;
		q.printList(node);
		q.printNode(q.findKthToTail(node, 5));
	}
}
