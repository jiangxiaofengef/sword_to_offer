package question;

import chapter2.data_structure.stack.ObjectStack;
import chapter2.data_structure.tree.TreeNode;
/**
 * 题目三：之字形打印二叉树
 * 实现一个函数之字形打印二叉树，即第一行从左到右，第二行从右到左，第三行从左到右，如此类推
 * @author Administrator
 *
 */
public class Question31_3 {
	private ObjectStack<TreeNode> leftStack = new ObjectStack<>();
	private ObjectStack<TreeNode> rightStack = new ObjectStack<>();
	
	public void printTree(TreeNode root) {
		boolean left = true;
		leftStack.push(root);
		TreeNode node;
		
		while(!leftStack.isEmpty() || !rightStack.isEmpty()) {
			if (left) {
				node = leftStack.pop();
				System.out.print(node.data + " ");
				
				if (node.left != null) {
					rightStack.push(node.left);
				}
				
				if (node.right != null) {
					rightStack.push(node.right);
				}
				
				if (leftStack.isEmpty()) {
					System.out.println();
					left = false;
				}
			} else {
				node = rightStack.pop();
				System.out.print(node.data + " ");
				
				if (node.right != null) {
					leftStack.push(node.right);
				}
				
				if (node.left != null) {
					leftStack.push(node.left);
				}
				
				if (rightStack.isEmpty()) {
					System.out.println();
					left = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Question31_3 q = new Question31_3();
		TreeNode n7 = new TreeNode(11);
		TreeNode n6 = new TreeNode(9);
		TreeNode n5 = new TreeNode(7);
		TreeNode n4 = new TreeNode(5);
		TreeNode n3 = new TreeNode(n6, n7, 10);
		TreeNode n2 = new TreeNode(n4, n5, 6);
		TreeNode root = new TreeNode(n2, n3, 8);
		
		q.printTree(root);
	}
}
