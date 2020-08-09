package question;

import chapter2.data_structure.tree.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称。
 * @author Administrator
 *
 */
public class Question28 {
	public boolean isSymmetry(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2== null) return true;
		
		if (node1 == null || node2 == null) return false;
		
		if (node1.data != node2.data) return false;
		
		return isSymmetry(node1.left, node2.right) && isSymmetry(node1.right, node2.left);
		
	}
	
	public static void main(String[] agrs) {
		TreeNode n7 = new TreeNode(5);
		TreeNode n6 = new TreeNode(7);
		TreeNode n5 = new TreeNode(7);
		TreeNode n4 = new TreeNode(5);
		TreeNode n3 = new TreeNode(n6, n7, 6);
		TreeNode n2 = new TreeNode(n4, n5, 6);
		TreeNode n1 = new TreeNode(n2, n3, 8);
		System.out.print(new Question28().isSymmetry(n1, n1));
	}
}
