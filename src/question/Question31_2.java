package question;
/**
 * 题目二：分行从上到下打印二叉树
 * 从上到下按层打印二叉树，同一层的节点按从左到又的顺序打印，每一层打印一行
 * @author Administrator
 *
 */

import chapter2.data_structure.queue.Queue;
import chapter2.data_structure.tree.TreeNode;

public class Question31_2 {
	private Queue<TreeNode> queue = new Queue<>();
	
	public void printTree(TreeNode root) {
		int nowPrint = 1;
		int nextPrint = 0;
		queue.add(root);
		TreeNode node;
		
		while(!queue.isEmpty()) {
			node = queue.get();
			System.out.print(node.data + " ");
			
			if (node.left != null) {
				queue.add(node.left);
				nextPrint++;
			}
			
			if (node.right != null) {
				queue.add(node.right);
				nextPrint++;
			}
			
			nowPrint--;
			
			if (nowPrint <= 0) {
				System.out.println();
				nowPrint = nextPrint;
				nextPrint = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Question31_2 q = new Question31_2();
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
