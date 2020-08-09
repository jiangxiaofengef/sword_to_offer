package question;

import java.util.ArrayList;

import chapter2.data_structure.tree.TreeNode;

/**
 * 请完成一个函数，输入一棵二叉树，该函数输出他的镜像
 * @author Administrator
 *
 */
public class Question27 {
	public static  void preorderTraversal(TreeNode head) {
		if (head == null) return;
		
		System.out.print(head.data + " ");
		preorderTraversal(head.left);
		preorderTraversal(head.right);
	}
	
	public void mirror(TreeNode node) {
		if (node == null) return;
		
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		mirror(node.left);
		mirror(node.right);
	}
	
	public void mirror2(TreeNode node) {
		if (node == null) return;
		
		ArrayList<TreeNode> treeNodeList = new ArrayList<>();
		treeNodeList.add(node);
		
		while(treeNodeList.size() > 0) {
			TreeNode n = treeNodeList.remove(treeNodeList.size() - 1);
			
			TreeNode temp = n.left;
			n.left = n.right;
			n.right = temp;
			
			if (n.left != null) treeNodeList.add(n.left);
			if (n.right != null) treeNodeList.add(n.right);
		}
	}
	
	public static void main(String[] agrs) {
		TreeNode n7 = new TreeNode(11);
		TreeNode n6 = new TreeNode(9);
		TreeNode n5 = new TreeNode(7);
		TreeNode n4 = new TreeNode(5);
		TreeNode n3 = new TreeNode(n6, n7, 10);
		TreeNode n2 = new TreeNode(n4, n5, 6);
		TreeNode n1 = new TreeNode(n2, n3, 8);
		preorderTraversal(n1);
		new Question27().mirror2(n1);
		System.out.println();
		preorderTraversal(n1);
	}
}
