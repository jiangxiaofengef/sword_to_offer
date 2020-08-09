package question;
/**
 * 从上到下打印二叉树
 * 题目一：不分行从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @author Administrator
 *
 */

import chapter2.data_structure.queue.Queue;
import chapter2.data_structure.tree.TreeNode;

public class Question32_1 {
	private Queue<TreeNode> queue = new Queue<>();
	
	public void printTree(TreeNode root) {
		queue.add(root);
		TreeNode node;
		
		while (!queue.isEmpty()) {
			node = queue.get();
			System.out.print(node.data + " ");
			
			if (node.left != null) {
				queue.add(node.left);
			}
			
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Question32_1 q = new Question32_1();
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
