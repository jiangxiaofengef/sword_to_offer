package chapter2.data_structure.String.question5;

/**
 *  请实现一个函数，把字符串中的每个空格替换成“%20”。例如输入“we are happy”，则输出“we%20are%20happy”
 * 本实现改成把每个‘.’替换成“%20”
 * @author Administrator
 *
 */
public class ReplaceCharacter {
	public static void main(String[] args) {
		char[] test = testFactory("test1");
		
		System.out.print("before: ");
		System.out.println(test);
		
		if (replace(test)) {
			System.out.println("after: ");
			System.out.println(test);
		} else {
			System.out.println("字符串输入错误!");
		}
	}
	
	public static boolean replace(char[] string) {
		if (string == null) {
			return false;
		}
		
		//空格数
		int spaceCount = 0;
		//修改字符串前长度
		int stringLength = 0;
		
		for (int i = 0; i < string.length; i++) {
			stringLength ++;
			
			if (string[i] == ' ') {
				spaceCount++;
			}
			
			if (string[i] == '\0') {
				break;
			}
		}
		
		//修改字符串后长度
		int afterReplaceLength = spaceCount * 2 + stringLength;
		
		if (afterReplaceLength > string.length) {
			return false;
		}
		
		//修改前的字符串末尾指针
		int beforePointer = stringLength - 1;
		//修改后字符串末尾指针
		int afterPointer = afterReplaceLength - 1;
		
		for (; spaceCount > 0;) {
			if (string[beforePointer] == ' ') {
				string[afterPointer--] = '0';
				string[afterPointer--] = '2';
				string[afterPointer--] = '%';
				spaceCount--;
				beforePointer--;
			} else {
				string[afterPointer--] = string[beforePointer--];
			}
		}
		
		return true;
	}
	
	//测试数据构造
	private static char[] testFactory(String testType) {
		switch (testType) {
			case "test1":
				return test1();
			case "test2":
				return test2();
			case "test3":
				return test3();
			case "test4":
				return test4();
			case "test5":
				return test5();
			case "test6":
				return test6();
			case "test7":
				return test7();
		}
		
		return null;
	}
	
	private static char[] test1() {
		char[] string = new char[13];
		string[0] = 'w';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = 'a';
		string[4] = 'r';
		string[5] = 'e';
		string[6] = ' ';
		string[7] = 'h';
		string[8] = 'a';
		string[9] = 'p';
		string[10] = 'p';
		string[11] = 'y';
		string[12] = '\0';
		return string;
	}
	
	private static char[] test2() {
		char[] string = new char[40];
		
		string[0] = 'w';
		string[1] = 'e';
		string[2] = '\0';
		
		return string;
	}
	
	private static char[] test3() {
		char[] string = new char[40];
		string[0] = 'w';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = ' ';
		string[4] = ' ';
		string[5] = ' ';
		string[6] = ' ';
		string[7] = ' ';
		string[8] = 'a';
		string[9] = 'r';
		string[10] = 'e';
		string[11] = ' ';
		string[12] = ' ';
		string[13] = 'h';
		string[14] = 'a';
		string[15] = 'p';
		string[16] = 'p';
		string[17] = 'y';
		string[18] = '\0';
		return string;
	}
	
	private static char[] test4() {
		char[] string = new char[40];
		string[0] = 'w';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = 'a';
		string[4] = 'r';
		string[5] = 'e';
		string[6] = ' ';
		string[7] = 'h';
		string[8] = 'a';
		string[9] = 'p';
		string[10] = 'p';
		string[11] = 'y';
		string[12] = '\0';
		return string;
	}
	
	private static char[] test5() {
		char[] string = new char[40];
		string[0] = ' ';
		string[1] = '\0';
		return string;
	}
	
	private static char[] test6() {
		char[] string = new char[40];
		
		string[0] = 'w';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = '\0';
		
		return string;
	}
	
	private static char[] test7() {
		char[] string = new char[40];
		
		string[0] = ' ';
		string[1] = 'w';
		string[2] = 'e';
		string[3] = '\0';
		
		return string;
	}
}
