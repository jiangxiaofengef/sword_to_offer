package chapter2.data_structure.queue;

import java.util.LinkedList;

public class Queue<E> {
	LinkedList<E> list = new LinkedList<>();
	
	public E get() {
		E e = list.removeFirst();
		return e;
	}
	
	public void add(E e) {
		list.addLast(e);
	}
	
	public boolean isEmpty() {
		if (list.size() > 0) {
			return false;
		}
		
		return true;
	}
}
