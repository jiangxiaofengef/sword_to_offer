package question;
/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在盖类型中实现一个能够得到栈的最小元素的min函数，在该栈中调用min，push和pop的时间复杂度都是O（1）
 * @author Administrator
 *
 */

import chapter2.data_structure.stack.ObjectStack;

public class Question30 {
	private ObjectStack<Integer> stack = new ObjectStack<>();
	private ObjectStack<Integer> minStack = new ObjectStack<>();
	private int minValue;
	
	public void push(int value) {
		if (stack.isEmpty()) {
			minStack.push(value);
			minValue = value;
		} else {
			minValue = minValue > value ? value : minValue;
			minStack.push(minValue);
		}
		
		stack.push(value);
	}
	
	public int pop() {
		assert(!stack.isEmpty());
		
		minStack.pop();
		minValue = minStack.pop();
		minStack.push(minValue);
		return stack.pop();
	}
	
	public int min() {
		assert(!stack.isEmpty());
		return minValue;
	}
	
	public static void main(String[] args) {
		Question30 s = new Question30();
		s.push(3);
		System.out.println(s.min());
		s.push(4);
		System.out.println(s.min());
		s.push(2);
		System.out.println(s.min());
		s.push(1);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.push(0);
		System.out.println(s.min());
	}
}
