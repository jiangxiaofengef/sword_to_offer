package chapter2.data_structure.array.question3;

/**
 * 题目一：找出数组中重复的数字
 *   在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如输入长度为7的数组{2,3,1,0,5,3},那么对应输出是2或3
 * @author Administrator
 * 测试用例：
 *   1.长度为n的数组里包含一个或多个重复数字
 *   2.数组不包含重复数据
 *   3.无效测试用例（空指针，长度为n的数组包含0~n-1之外的数字）
 */
public class FindDuplicateData {
	public static void main(String[] args) {
		int[] test = {2,3,1,0,9,3,3,2,5,3};
		int find = new FindDuplicateData().findDuplicate(test);
		
		if (find == -1) {
			System.out.println("没有重复的数字");
		} else {
			System.out.println("重复数字为：" + find);
		}
	}
	
	public int findDuplicate(int[] array) {
		if (array != null && array.length > 0) {
			int m = 0;
			int find;
			int size = array.length;
			
			for (int i = 0; i < size; i++) {
				if (array[i] >= size) {
					return -1;
				}
			}
			
			while(m < size) {
				find = array[m];
				
				//判断find在不在自己位置上
				if (m == find) {
					m++;
					continue;
				}
				
				//与find所在位置的数对比，如果相等，则代表有重复的数，否则把find换到自己的位置上
				if (find == array[find]) {
					return find;
				} else {
					swap(array, m, find);
				}
			}
		}
		
		return -1;
	}
	
	private void swap (int[] array, int index1, int index2) {
		int temp;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
