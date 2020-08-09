package chapter2.data_structure.stack;

import chapter2.data_structure.queue.Queue;

public class TwoQueueToStack<E> {
	Queue<E> aQueue = new Queue<>();
	Queue<E> bQueue = new Queue<>();
	
	public E pop() {
		if (bQueue.isEmpty()) {
			E e = aQueue.get();
			
			while (!aQueue.isEmpty()) {
				bQueue.add(e);
				e = aQueue.get();
			}
			
			return e;
		}
		
		E e = bQueue.get();
		
		while (!bQueue.isEmpty()) {
			aQueue.add(e);
			e = bQueue.get();
		}
		
		return e;
	}
	
	public void push(E e) {
		if (aQueue.isEmpty()) {
			bQueue.add(e);
		} else {
			aQueue.add(e);
		}
	}
	
	public static void main(String[] args) {
		TwoQueueToStack<Integer> stack = new TwoQueueToStack<>();
		
		for (int i = 1; i <= 10; i++) {
			if (i >= 6) {
				System.out.println(stack.pop());
			}
			
			stack.push(i);
		}
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(stack.pop());
		}
	}
}
