package chapter2.data_structure.array.question4;import java.lang.reflect.Array;

/**
 * 题目：在一个二维数组中每一行都按照从左到右的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * @author Administrator
 *
 */
public class Matrix {
	public static void main(String[] args) {
		int[][] testArrry1 = {
				{1, 2, 8, 9}, 
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}};
		int[][] testArray2 = null;
		int[][] testArray3 = {};
		int[][] testArray4 = {{}, {}};
		int[][] testArray5 = {{1,2}, {}};
		int[][] testArray6 = {
				{12, 2, 8, 9}, 
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}};
		
		System.out.println(findData(testArray6, 10));
	}
	
	public static boolean findData(int[][] array, int data) {
		if (null == array || array.length <= 0 || array[0].length <= 0) {
			return false;
		}
		
		int column = array.length;
		int row = array[0].length;
		
		for (int i = 0; i < column; i++) {
			//判断是否为矩阵
			if (array[i].length != row) {
				return false;
			}
		}
		
		for (int i = 0; i < column; i++) {
			//判断矩阵是否符合从左到右，从上到下递增
			for (int j = 0; j < row; j++) {
				if (i + 1 < column && array[i+1][j] <= array[i][j]) {
					return false;
				}
				
				if (j + 1 < row && array[i][j+1] <= array[i][j]) {
					return false;
				}
			}
		}
		
		//从右上角开始，从右到左，从上到下判断输入数字在不在矩阵内
		for (int i = column - 1; i >= 0; i--) {
			for (int j = 0; j < row; j++) {
				if (data == array[i][j]) {
					return true;
				}
				
				if (data < array[i][j]) {
					break;
				}
				
				if (data > array[i][j]) {
					continue;
				}
			}
		}
		
		return false;
	}
}
