package chapter2.data_structure.other;

public class Finonacci {
	public int circulation(int n) {
		if (n == 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		int i;
		int a = 0;
		int b = 1;
		
		for (i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				a = a + b;
			} else {
				b = a + b;
			}
		}
		
		if (i % 2 == 0) {
			return b;
		}
		
		return a;
	}
	
	public int recursion(int n) {
		if (n == 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		return recursion(n - 1) + recursion(n - 2);
	}
	
	public static void main(String[] args) {
		System.out.println(new Finonacci().circulation(10));
		System.out.println(new Finonacci().recursion(10));
	}
}
