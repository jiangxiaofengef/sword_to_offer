package chapter2.data_structure.link;

import chapter2.data_structure.stack.ObjectStack;

/**
 * 从头到尾打印链表
 * @author Administrator
 *
 */
public class PrintLinkList {
	public void printList(LinkList head) {
		ObjectStack<LinkList> stack = new ObjectStack<>();
		
		if (head == null) {
			return;
		}
		
		LinkList p = head;
		
		while (p != null) {
			stack.push(p);
			p = p.next;
		}
		
		while ((p = stack.pop()) != null) {
			System.out.println(p.data);
		}
	}
	
	public static void main(String[] args) {
		LinkList<Integer> p = new LinkList<>();
		LinkList<Integer> next;
		LinkList<Integer> head = p;
		p.data = new Integer(0);
		
		for (int i = 1; i <= 9; i++ ) {
			next = new LinkList<>();
			p.next = next;
			next.data = new Integer(i);
			p = next;
		}
		
		new PrintLinkList().printList(head);
	}
}
