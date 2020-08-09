package question;
/**
 * 输入一个矩阵，按照从外到里以顺时针顺序依次打印出矩阵元素
 * @author Administrator
 *
 */
public class Questtion29 {
	public void clockwisePrintArray(int[][] array, int columns, int rows) {
		if (array == null || columns <= 0 || rows < 0) return;
		
		int start = 0;
		
		while(columns > start * 2 && rows > start * 2) {
			clockwisePrint(array, columns, rows, start);
			start++;
		}
	}

	public void clockwisePrint(int[][] array, int columns, int rows, int start) {
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		
		// 从左到有打印
		for (int i = start; i <= endY; i++) {
			System.out.print(array[start][i] + " ");
		}
		
		// 从上到下打印
		if (start < endY) {
			for (int i = start + 1; i <= endX; i++) {
				System.out.print(array[i][endY] + " ");
			}
		}
		
		if(start < endX && start < endY) {
			for (int i = endY - 1; i >= start; i--) {
				System.out.print(array[endX][i] + " ");
			}
		}
		
		if(start < endX && start < endY -1) {
			for (int i = endX - 1; i > start; i--) {
				System.out.print(array[i][start] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		new Questtion29().clockwisePrintArray(a, 4, 4);
	}
}
