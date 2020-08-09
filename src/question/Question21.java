package question;
/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * @author Administrator
 *
 */
public class Question21 {
	public void reorderOddEven(int[] array, Func func) {
		if (array == null || array.length <= 1) {
			return;
		}
		
		int begin = 0;
		int end = array.length - 1;
		
		while (begin < end) {
			while (begin  < array.length && !func.func(array[begin])) {
				begin++;
			}
			
			while (end > 0 && func.func(array[end])) {
				end--;
			}
			
			if (begin < end) {
				int temp = array[begin];
				array[begin] = array[end];
				array[end] = temp;
			}
		}
		
	} 
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		printArray(array);
		new Question21().reorderOddEven(array, new OddFunc());
		printArray(array);
	}
}

interface Func {
	boolean func(int i);
}

class OddFunc implements Func {

	@Override
	public boolean func(int i) {
		if (i % 2 == 0) {
			return true;
		}
		
		return  false;
	}
	
}
