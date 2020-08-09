package chapter2.data_structure.other;

public class ReverseMin {
	public int findMin(int[] array) {
		int start = 0;
		int end = array.length - 1;
		
		return find(array, start, end);
	}

	private int find(int[] array, int start, int end) {
		int middle = (start + end) / 2;
		
		if (start == end || end - start == 1) {
			if (array[start] < array[end]) {
				return array[start];
			} else {
				return array[end];
			}
		}
		
		if (array[start] == array[middle] && array[end] == array[middle]) {
			int min = array[start];
			
			for (int i = start + 1; i <= end; i++) {
				if (array[i] < min) {
					min = array[i];
				}
			}
			
			return min;
		}
		
		if (array[start] > array[middle]) {
			return find(array, start, middle);
		}
		
		return find(array, middle, end);
	}
	
	public static void main(String[] args) {
		int[] a = {3,4,5,1,2};
		int[] b = {1,1,1,0,1};
		int[] c = {1,1,1,1,1};
		ReverseMin reverseMin = new ReverseMin();
		System.out.println(reverseMin.findMin(c));
	}
}
