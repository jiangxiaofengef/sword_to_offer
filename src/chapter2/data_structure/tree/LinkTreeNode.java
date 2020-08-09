package chapter2.data_structure.tree;

public class LinkTreeNode {
	public LinkTreeNode right;
	public LinkTreeNode left;
	public LinkTreeNode parent;
	public char data;
	
	public LinkTreeNode() {
		
	}
	
	public LinkTreeNode(char data) {
		this.data = data;
	}
	
	public LinkTreeNode(LinkTreeNode left, LinkTreeNode right, char data) {
		this.right = right;
		this.left = left;
		this.data = data;
	}
	
	public LinkTreeNode(LinkTreeNode parent, LinkTreeNode left, LinkTreeNode right, char data) {
		this.parent = parent;
		this.right = right;
		this.left = left;
		this.data = data;
	}
}
