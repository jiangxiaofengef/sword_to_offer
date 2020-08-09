package question;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 * @author Administrator
 *
 */
public class Question24 {
	private class ListNode {
		public ListNode(int value) {
			this.value = value;
		}
		
		public int value;
		public ListNode next;
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode reverseHead = null;
		ListNode preNode = null;
		ListNode currentNode = head;
		ListNode nextNode = null; 
		
		while (currentNode != null) {
			nextNode = currentNode.next;
			
			if (nextNode == null) {
				reverseHead = currentNode;
			}
			
			currentNode.next = preNode;
			preNode = currentNode;
			currentNode = nextNode;
		}
		
		return reverseHead;
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
		Question24 q = new Question24();
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
		q.printList(q.reverseList(node));
	}
}
