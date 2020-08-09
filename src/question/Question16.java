package question;
/**
 * 数值的整数次方
 * 实现函数double power(double base, int exponent),求base的exponent次方。不得使用库函数，同时不需要考虑大数问题
 * @author Administrator
 *
 */
public class Question16 {
	public static boolean isError = false;
	
	double power(double base, int exponent) {
		isError = false;
		
		if (base == 0.0 &&  exponent < 0) {
			isError = true;
			return 0.0;
		}
		
		if (base == 0.0) {
			return 0.0;
		}
		
		int abs_exponent;
		
		if (exponent < 0) {
			abs_exponent = - exponent;
		} else {
			abs_exponent = exponent;
		}
		
		double result = powerWithExponent(base, abs_exponent);
		
		if (exponent < 0) {
			result = 1 / result;
		}
		
		return result;
	}
	
	double powerWithExponent(double base, int abs_exponent) {
		if (abs_exponent == 0) {
			return 1.0;
		}
		
		double result = base;
		
		while (abs_exponent >= 2) {
			result *= result;
			abs_exponent = abs_exponent >> 1;
		}
		
		if (abs_exponent == 1) {
			result *= base;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new Question16().power(2.0, -5));;
	}
}
