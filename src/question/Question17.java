package question;
/**
 * 打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n为十进制数。比如输入3，则打印出1,2,3一直到最大的3位数到999
 * @author Administrator
 *
 */
public class Question17 {
	void print1ToMaxN(int n) {
		char[] number = new char[n];
		
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		
		for (int i = 0; i < 10; i++) {
			number[0] = Character.forDigit(i, 10);
			print1ToMaxNRecursively(number, n-1, 0);
		}
	}
	
	void print1ToMaxNRecursively(char[] number, int n, int index) {
		if (index == n) {
			printNumber(number);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			number[index + 1] = Character.forDigit(i, 10);
			print1ToMaxNRecursively(number, n, index + 1);
		}
	}
	
	void printNumber(char[] number) {
		boolean isBeginning = true;
		int length = number.length;
		
		for (int i = 0; i < length; i++) {
			if (isBeginning && number[i] != '0') {
				isBeginning = false;
			}
			
			if (!isBeginning) {
				System.out.print(number[i]);
			}
		}
		
		if (!isBeginning) {
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Question17().print1ToMaxN(3);
	}
}
