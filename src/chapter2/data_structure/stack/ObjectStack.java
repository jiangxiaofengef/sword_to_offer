package chapter2.data_structure.stack;

import java.util.LinkedList;
import java.util.List;


public class ObjectStack<E> {
	private List<E> list = new LinkedList<>();
	private E head = null;
	
	public E pop() {
		E data = head;
		list.remove(data);
		
		if (list.size() > 0) {
			head = list.get(list.size() - 1);
		} else {
			head = null;
		}
		
		return data;
	}
	
	public void push(E e) {
		list.add(e);
		head = list.get(list.size() - 1);
	}
	
	public boolean isEmpty() {
		if (list.size() > 0) {
			return false;
		}
		
		return true;
	}
}
