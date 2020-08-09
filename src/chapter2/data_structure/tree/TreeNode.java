package chapter2.data_structure.tree;

public class TreeNode {
	public TreeNode right;
	public TreeNode left;
	public TreeNode parent;
	public int data;
	
	public TreeNode() {
		
	}
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode(TreeNode left, TreeNode right, int data) {
		this.right = right;
		this.left = left;
		this.data = data;
	}
	
	public TreeNode(TreeNode parent, TreeNode left, TreeNode right, int data) {
		this.parent = parent;
		this.right = right;
		this.left = left;
		this.data = data;
	}
}
