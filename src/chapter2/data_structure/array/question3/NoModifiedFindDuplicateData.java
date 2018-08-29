package chapter2.data_structure.array.question3;

/**
 * 题目二：不修改数组找出数组中重复的数字
 *   在一个长度为n+1的数组里所有数字都在1~n的范围内，所以数组至少有一个数字是重复的。请找出数组
 * 中任意一个重复的数字，但不能修改输入的数组。例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}
 * 那么对应输出是重复数字2或3
 * @author Administrator
 *   1.长度为n的数组里包含一个或多个重复数字
 *   2.数组不包含重复数据
 *   3.无效测试用例（空指针，长度为n的数组包含1~n之外的数字）
 */
public class NoModifiedFindDuplicateData {
	public static void main(String[] args) {
		int[] test1 = {2,3,1,0,2,3,3,2,5,3};
		int[] test2 = {2,3,1,2,3,3,2,5,3};
		int[] test3 = {1,2,3,4,5};
		int[] test4 = {5,6,5,5,3,5,5,6,6,6};
		int[] test5 = {};
		int[] test6 = null;
		int find = new NoModifiedFindDuplicateData().findDuplicate(test6);
		
		if (find == -1) {
			System.out.println("没有重复的数字");
		} else {
			System.out.println("重复数字为：" + find);
		}
	}
	
	public int findDuplicate(int[] array) {
		if (array != null && array.length > 0) {
			int size = array.length;
			
			for (int i = 0; i < size; i++) {
				if (array[i] >= size || array[i] == 0) {
					return -1;
				}
			}
			
			int min1 = 1;
			int min2 = size / 2;
			int max1 = size / 2 + 1;
			int max2 = size - 1;
			int minCount;
			int maxCount;
			
			while (min1 <= min2) {
				minCount = 0;
				maxCount = 0;
				
				//计数
				for (int i = 0; i < array.length; i++) {
					if (min1 <= array[i] && min2 >= array[i]) {
						minCount++;
					} else if (max1 <= array[i] && max2 >= array[i]) {
						maxCount++;
					}
				}
			
				//判断是不是在小一部分
				if (minCount > min2 - min1 + 1) {
					if (min1 == min2) {
						return min1;
					}
					
					max2 = min2;
					max1 = (max2 + min1) / 2 + 1;
					min2 = (max2 + min1) / 2;
				}
				
				//判断是不是在大一部分
				if (maxCount > max2 - max1 + 1) {
					if (max1 == max2) {
						return max1;
					}
					
					min1 = max1;
					max1 = (max2 + min1) / 2 + 1;
					min2 = (max2 + min1) / 2;
				}
			}
		}
		
		return -1;
	}
}
