package chapter2.data_structure.back;

import java.awt.Label;

public class ArrayPath {
	public boolean findArrayPath(char[][] array, char[] path) {
		if (array == null || path == null) {
			return  false;
		}
		
		boolean flag = false;
		
		label: 
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == path[0]) {
					int[] visit = new int[path.length];
					
					for (int k = 0; k < visit.length; k++) {
						visit[k] = -1;
					}
					
					if (flag = findPath(array, i, j, path, 0, visit)) {
						break label;
					}
				}
			}
		}
		
		return flag;
	}
	
	public boolean findPath(char[][] array, int iIndex, int jIndex, char[] path, int pathIndex, int[] visit) {
		if (pathIndex == path.length - 1) {
			if (array[iIndex][jIndex] == path[pathIndex]) {
				return true;
			}
		}
		
		if (pathIndex >= path.length) {
			return false;
		}
		
		boolean flag = false;
		boolean result = false;
		pathIndex++;
		visit[pathIndex] = (iIndex) * array.length + (jIndex);
		
		if (jIndex - 1 >= 0) {
			for (int i = 0; i < pathIndex; i++) {
				if (visit[i] == (iIndex) * array.length + (jIndex - 1)) {
					flag = true;
					break;
				}
			}
			
			if (!flag && path[pathIndex] == array[iIndex][jIndex - 1]) {
				result = findPath(array, iIndex, jIndex - 1, path, pathIndex, visit);
			}
		}
		
		flag = false;
		
		if (!result && jIndex + 1 < array[0].length) {
			for (int i = 0; i < pathIndex; i++) {
				if (visit[i] == (iIndex) * array.length + (jIndex + 1)) {
					flag = true;
					break;
				}
			}
			
			if (!flag && path[pathIndex] == array[iIndex][jIndex + 1]) {
				result = findPath(array, iIndex, jIndex + 1, path, pathIndex, visit);
			}
		}
		
		flag = false;
		
		if (!result && iIndex - 1 >= 0) {
			for (int i = 0; i < pathIndex; i++) {
				if (visit[i] == (iIndex - 1) * array.length + (jIndex)) {
					flag = true;
					break;
				}
			}
			
			if (!flag && path[pathIndex] == array[iIndex - 1][jIndex]) {
				result = findPath(array, iIndex - 1, jIndex, path, pathIndex, visit);
			}
		}
		
		flag = false;
		
		if (!result && iIndex + 1 < array.length) {
			for (int i = 0; i < pathIndex; i++) {
				if (visit[i] == (iIndex + 1) * array.length + (jIndex)) {
					flag = true;
					break;
				}
			}
			
			if (!flag && path[pathIndex] == array[iIndex + 1][jIndex]) {
				result = findPath(array, iIndex + 1, jIndex, path, pathIndex, visit);
			}
		}
			
		return result;
	}
	
	public static void main(String[] args) {
		char[][] array = {
			{'a', 'b', 't', 'g'},
			{'c', 'f', 'c', 's'},
			{'j', 'd', 'e', 'h'}
		};
		
//		char[] path = {'b', 'f', 'c', 'e'};
		char[] path1 = {'a', 'b', 'f', 'b'};
		
		System.out.println(new ArrayPath().findArrayPath(array, path1));
	}
}


