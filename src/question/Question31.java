package question;
/**
 * 栈的压入，弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如。序列{1,2,3,4,5},序列{4,5,3,2,1}是该栈序列对应的一个弹出序列，但{4,3,5,1,2}就不是该压栈的弹出序列
 * @author Administrator
 *
 */

import chapter2.data_structure.stack.ObjectStack;

public class Question31 {
	public boolean judge(int[] stackSer, int[] popSer) {
		ObjectStack<Integer> stack = new ObjectStack<>();
		
		if (stackSer.length != popSer.length) {
			return false;
		}
		
		int stackIndex = 0;
		int popIndex = 0;
		
		while (stackIndex < stackSer.length) {
			if (stackSer[stackIndex] == popSer[popIndex]) {
				stackIndex++;
				popIndex++;
			} else {
				stack.push(stackSer[stackIndex]);
				stackIndex++;
			}
		}
		
		if (popIndex >= popSer.length) {
			return true;
		}
		
		while(popIndex < popSer.length) {
			if (stack.pop() != popSer[popIndex]) {
				return false;
			}
			
			popIndex++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Question31 q = new Question31();
		int[] stackArr = {1,2,3,4,5};
		int[] popArr1 = {4,5,3,2,1};
		int[] popArr2 = {4,3,5,1,2};
		System.out.println(q.judge(stackArr, popArr1));
		System.out.println(q.judge(stackArr, popArr2));
	}
	
}
