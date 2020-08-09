package chapter2.data_structure.tree;

public class RebuildTree {
	public TreeNode rebulid(int[] before, int[] middle) {
		if (before.length <= 0 || middle.length <= 0 || before.length != middle.length) {
			return null;
		}
		
		return build(before, middle, 0, 0, before.length - 1);
	}
	
	private TreeNode build(int[] before, int[] middle, int start_before, int start_middle, int length) {
		if (length == -1) {
			return null;
		}
		
		if (length == 0) {
			return new TreeNode(before[start_before]);
		}
		
		int data = before[start_before];
		int countLength = 0;
		int flag = start_middle;
		
		for (int i = start_middle; i <= start_middle + length; i++) {
			if (middle[i] == data) {
				flag = i;
				break;
			}
			
			countLength++;
		}
		
		return new TreeNode(
				build(before, middle, start_before + 1, start_middle, countLength - 1),
				build(before, middle, start_before + countLength + 1, start_middle + countLength + 1, start_middle + length - flag - 1),
				data);
	}
	
	public static void main(String[] args) {
		int[] before = {
				1,2,4,7,3,5,6,8
		};
		
		int[] middle = {
				4,7,2,1,5,3,8,6
		};
		
		TreeNode root = new RebuildTree().rebulid(before, middle);
		System.out.println("success");
	}
}
