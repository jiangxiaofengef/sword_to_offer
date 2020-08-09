package question;
/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构
 * @author Administrator
 *
 */
public class Question26 {
	private class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	public boolean isSubTree(TreeNode parent, TreeNode son) {
		boolean result = false;
		
		if (parent != null && son != null) {
			if (parent.value == son.value) {
				result = isSub(parent, son);
			}
			
			if (!result) {
				result = isSubTree(parent.left, son);
			}
			
			if (!result) {
				result = isSubTree(parent.right, son);
			}
		}
		
		return result;
	}
	
	public boolean isSub(TreeNode parent, TreeNode son) {
		if (son == null) {
			return true;
		}
		
		if (parent == null) {
			return false;
		}
		
		if (parent.value != son.value) {
			return  false;
		}
		
		return isSub(parent.left, son.left) && isSub(parent.right, son.right);
	}
	
	public static void main(String[] args) {
		Question26 q = new Question26();
		TreeNode node = q.new TreeNode(8);
		TreeNode node1 = q.new TreeNode(8);
		TreeNode node2 = q.new TreeNode(7);
		node.left = node1;
		node.right = node2;
		TreeNode node3 = q.new TreeNode(9);
		TreeNode node4 = q.new TreeNode(2);
		node1.left = node3;
		node1.right = node4;
		TreeNode node5 = q.new TreeNode(4);
		TreeNode node6 = q.new TreeNode(7);
		node4.left = node5;
		node4.right = node6;
		
		TreeNode node7 = q.new TreeNode(8);
		TreeNode node8 = q.new TreeNode(8);
		TreeNode node9 = q.new TreeNode(7);
		node7.left = node8;
		node7.right = node9;
		
		System.out.println(q.isSubTree(node, node7));
	}
}
