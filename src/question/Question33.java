package question;
/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个
 * 数字互不相同
 * @author Administrator
 *
 */
public class Question33 {
	public boolean isSearchTree(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return true;
		}
		
		int root = array[endIndex];
		int i = startIndex;
		
		for (; array[i] < root && i < endIndex; i++) {
			
		}
		
		for(; i < endIndex; i++) {
			if (array[i] < root) {
				return false;
			}
		}
		
		return isSearchTree(array, 0, i - 1) && isSearchTree(array, i, endIndex - 1);
	}
	
	public static void main(String[] args) {
		Question33 q = new Question33();
		int[] array = {5,7,6,9,11,10,8};
		int[] array1 = {7,4,6,5};
		System.out.println(q.isSearchTree(array, 0, array.length - 1));
		System.out.println(q.isSearchTree(array1, 0, array1.length - 1));
	}
}
