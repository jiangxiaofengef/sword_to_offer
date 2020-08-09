package question;

import chapter2.data_structure.tree.TreeNode;

/**
 * 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从根节点开始往下一直到叶子节点所经过的节点形成一条路径
 * @author Administrator
 *
 */
public class Question34 {
	public void printRoad(TreeNode root, int expectedSum) {
		findPath(root, "", 0, expectedSum);
	}
	
	public void findPath(TreeNode node, String road, int sum, int expectedSum) {
		sum += node.data;
		
		if (sum > expectedSum ||
				sum == expectedSum &&
				node.left != null &&
				node.right != null) {
			return; 
		}
		
		if (sum == expectedSum &&
				node.left == null &&
				node.right == null) {
			System.out.println(road + node.data);
		}
		
		if(node.left != null) {
			findPath(node.left, road + node.data + "->", sum, expectedSum);
		}
		
		if(node.right != null) {
			findPath(node.right, road + node.data + "->", sum, expectedSum);
		}
	}
	
	public static void main(String[] args) {
		Question34 q = new Question34();
		TreeNode n5 = new TreeNode(7);
		TreeNode n4 = new TreeNode(4);
		TreeNode n3 = new TreeNode(12);
		TreeNode n2 = new TreeNode(n4, n5, 5);
		TreeNode root = new TreeNode(n2, n3, 10);
		
		q.printRoad(root, 22);
	}
}
